<%@page import="org.json.JSONObject"%>
<%@page import="community.dao.CommunityDAO"%>
<%@page import="community.bean.CommunityDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String user_name = request.getParameter("user_name");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

	String str_seq = request.getParameter("seq");
	int seq = 0;
	if (str_seq != null) {
		if (!str_seq.trim().equals("") && str_seq.matches("^[0-9]*$")) {
			seq = Integer.parseInt(str_seq);
		}
	}

	String user_pwd = request.getParameter("user_pwd");

	CommunityDTO communityDTO = new CommunityDTO();
	communityDTO.setUser_name(user_name);
	communityDTO.setEmail(email);
	communityDTO.setSubject(subject);
	communityDTO.setContent(content);
	communityDTO.setSeq(seq);
	communityDTO.setUser_pwd(user_pwd);

	CommunityDAO communityDAO = new CommunityDAO();
	int result = communityDAO.communityUpdate(communityDTO);
	String rt = null;
	if (result > 0) {
		rt = "OK";
	} else {
		rt = "Fail";
	}
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("seq", seq);
	out.println(json);
	System.out.println(json);
%>
