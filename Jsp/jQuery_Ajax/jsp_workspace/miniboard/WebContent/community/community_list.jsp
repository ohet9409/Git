<%@page import="files.dao.FilesDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="community.bean.CommunityDTO"%>
<%@page import="java.util.List"%>
<%@page import="community.dao.CommunityDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String dir = request.getServletContext().getRealPath("/storage");

	// DB
	CommunityDAO dao = new CommunityDAO();
	List<CommunityDTO> list = dao.commnityList();

	// JSON
	String rt = null;
	int total = list.size(); // 조회된 데이터 수
	//	조회된 데이터 수로 성공/실패 판단
	if (total > 0) {
		rt = "OK";
	} else {
		rt = "Fail";
	}
	//	json 객체 생성
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	FilesDAO filesDAO = new FilesDAO();
	//	json 배열 만들기
	if (total > 0) {
		JSONArray item = new JSONArray();

		for (int i = 0; i < list.size(); i++) {
			CommunityDTO communityDTO = list.get(i);
			// 파일 이름 구하기
			String filename = filesDAO.checkFiles(communityDTO.getSeq());
			// 파일 URL
			String fileURL = "";
			//	파일이 있는지 검사해서, 있으면 파일이름 얻어오기
			if (filename != null) {
				fileURL = "http://192.168.0.61:8080/miniboard/storage" + "/" + filename;
			}
			System.out.println("filename : " + filename);
			JSONObject temp = new JSONObject();
			temp.put("filename", fileURL);
			temp.put("seq", communityDTO.getSeq());
			temp.put("user_name", communityDTO.getUser_name());
			temp.put("user_pwd", communityDTO.getUser_pwd());
			temp.put("email", communityDTO.getEmail());
			temp.put("subject", communityDTO.getSubject());
			temp.put("content", communityDTO.getContent());
			temp.put("reg_date", communityDTO.getReg_date());
			temp.put("edit_date", communityDTO.getEdit_date());
			//	json 배열에 추가
			item.put(i, temp);
		}
		//	json 객체에 배열 추가
		json.put("item", item);
	}
	out.println(json);
	System.out.println(json);
%>
