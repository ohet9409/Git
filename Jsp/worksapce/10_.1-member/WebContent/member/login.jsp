<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터 처리
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

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
<% if(name != null) { %>
	<p><%=name %>님이 로그인</p>
<% } else { %>
	<p>아이디나 비밀번호가 틀렸습니다.</p>
<% } %>
</body>
</html>




