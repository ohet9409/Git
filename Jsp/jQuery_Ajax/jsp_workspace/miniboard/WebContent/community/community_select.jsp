<%@page import="files.dao.FilesDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="community.dao.CommunityDAO"%>
<%@page import="community.bean.CommunityDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//	데이터
	String str_seq = request.getParameter("seq");
	int seq = 0;
	if (str_seq != null) {
		if (!str_seq.trim().equals("") && str_seq.matches("^[0-9]*$")) {
			seq = Integer.parseInt(str_seq);
		}
	}
	// DB
	CommunityDAO communityDAO = new CommunityDAO();
	CommunityDTO communityDTO = communityDAO.communitySelect(seq);
	// JSON
	String rt = "";
	System.out.println("seq : " + seq);
	System.out.println("str_seq : " + str_seq);
	//   System.out.println("user_name : " + communityDTO.getUser_name());
	if (communityDTO != null) {
		rt = "OK";

	} else {
		rt = "FAIL";
	}
	JSONObject json = new JSONObject();

	json.put("rt", rt);
	json.put("total", 1);
	if (communityDTO != null) {
		FilesDAO filesDAO = new FilesDAO();
		// 파일 이름 구하기
		String filename = filesDAO.checkFiles(communityDTO.getSeq());
		// 파일 URL
		String fileURL = "";
		//	파일이 있는지 검사해서, 있으면 파일이름 얻어오기
		if (filename != null) {
			fileURL = "http://192.168.0.61:8080/miniboard/storage" + "/" + filename;
		}
		JSONArray item = new JSONArray();
		JSONObject temp = new JSONObject();
		temp.put("seq", communityDTO.getSeq());
		temp.put("filename", fileURL);
		temp.put("user_name", communityDTO.getUser_name());
		temp.put("user_pwd", communityDTO.getUser_pwd());
		temp.put("email", communityDTO.getEmail());
		temp.put("subject", communityDTO.getSubject());
		temp.put("content", communityDTO.getContent());
		temp.put("reg_date", communityDTO.getReg_date());
		temp.put("edit_date", communityDTO.getEdit_date());
		item.put(0, temp);
		json.put("item", item);
	}

	out.println(json);
	System.out.println(json);
%>
