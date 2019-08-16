
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String name="홍길동";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** include 지시자 **</h3>
<%@ include file="today.jsp" %>	<!-- 자바부분까지 포함 -->
<h3>** include JSP tag **</h3>
<jsp:include page="image.jsp"/>	<!-- HTML부분만 포함 -->
<p>name = <%=name %></p>
</body>
</html>