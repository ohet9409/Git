<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	// DB 처리
    	MemberDTO memberDTO = new MemberDTO();
    	MemberDAO memberDAO = new MemberDAO();
    	String name = memberDAO.login(id, pwd);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(name!=null){ %>
	<%=name %>님이 로그인
	<%} else { %>
	존재하지 않는 데이터입니다.
	<%} %> 
</body>
</html>