<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	MemberDAO dao = new MemberDAO();
    	String name = dao.login(id, pwd);
    	
    	if(name != null){	// log on 상태
    		session.setAttribute("memId", id);
    		session.setAttribute("memName", name);
    		response.sendRedirect("../board/boardList.jsp?pg=1");
    	} else {			// log off 상태
    		response.sendRedirect("loginForm.jsp");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%if(name == null){ %>
		로그인 실패
	<%}else{ %>
		<%=name %>님 로그인
	<%} %>
 --%>
 </body>
</html>