<%@page import="files.dao.FilesDAO"%>
<%@page import="files.bean.FilesDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.json.JSONObject"%>
<%@page import="community.dao.CommunityDAO"%>
<%@page import="community.bean.CommunityDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//	실제 폴더 위치 : "/storage" 폴더 위치를 찾아온다.
	String dir = request.getServletContext().getRealPath("/storage");

	String str_seq = request.getParameter("seq");
	int seq = 0;
	if (str_seq != null) {
		if (!str_seq.equals("") && str_seq.matches("^[0-9]*$")) {
			seq = Integer.parseInt(str_seq);
		}
	}
	String user_pwd = request.getParameter("user_pwd");

	CommunityDTO communityDTO = new CommunityDTO();
	communityDTO.setSeq(seq);
	communityDTO.setUser_pwd(user_pwd);

	CommunityDAO communityDAO = new CommunityDAO();
	int result = communityDAO.communityDelete(seq, user_pwd, communityDTO);
	//	JSON으로 결과값 반환
	String rt = null;
	if (result > 0) {
		rt = "OK";
	} else {
		rt = "FAIL";
	}
	// 게시판 글을 지운 후에 파일 삭제
	if (rt.equals("OK")) {
		FilesDAO filesDAO = new FilesDAO();
		//	파일이 있는지 검사해서, 있으면 파일이름 얻어오기
		String filename = filesDAO.checkFiles(seq);
		System.out.println("filename : " + filename );
		int result2=0;
		// 파일이 있으면 삭제
		if(filename != null){
			String filePath = dir + "\\" + filename;
			System.out.println("filePath : " + filePath );
			result2 = filesDAO.filesDelete(seq, filePath);
			if (result2 > 0) {
				rt = "OK";		// 파일까지 지워야만 OK
			} else {
				rt = "Fail";
			}
		}
	}
	// Json 객체 생성
	JSONObject json = new JSONObject(); // {} : 객체 생성 직후에는 텅빈 {}만 만들어 진 것임
	json.put("rt", rt); //	{"rt" : "OK"} 또는 {"rt" : "FAIL"}
	out.println(json);

	System.out.println(json);
%>
