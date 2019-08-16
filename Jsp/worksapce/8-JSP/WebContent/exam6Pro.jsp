<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String name = request.getParameter("name");
    	String tel = request.getParameter("tel");
    	String local = request.getParameter("local");
    	String localNum = "";
    	switch (local){
    	case "서울" : localNum ="02"; break;
    	case "경기" : localNum ="031"; break;
    	case "강원" : localNum ="033"; break;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%=name %>님의 전화번호는 <%= localNum %> - <%=tel %>입니다.
</body>
</html>