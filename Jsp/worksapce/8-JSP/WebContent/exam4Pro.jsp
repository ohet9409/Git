<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
    String str ="";
    if(age>=20){
    	str ="20세 이상입니다";
    } else {
    	str ="20세 미만입니다";
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= name %>님의 나이는 <%= age %>세 이므로  <%=str %>.<br>
	<br>//////////////////////<br>
	body에서 작성하기 <br>
	
	<% if(age>=20) {%>
	
	<p><%= name %>님의 성인입니다.</p>
	
	<%} else {%>
	
	<p><%= name %>님의 성인이 아닙니다.</p>
	
	<%}%>	
</body>
</html>