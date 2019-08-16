<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		 // 페이지 이동
		 String name="hong";
 		//response.sendRedirect("sendResult.jsp?name="+name); //get 방식
 		 response.sendRedirect("sendResult.jsp");	
 		//session.setAttribute("name",name); */		// session 이용
 		
 		request.setAttribute("name",name);	//request 이용
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>현재 페이지는 send.jsp 입니다.</p>
</body>
</html>