<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 		// 데이터
 		/* request.setCharacterEncoding("utf-8"); */
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		/* String imageName = request.getParameter("imageName"); */
		// DB
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		int su = imageboardDAO.imageboardDelete(seq);
		// 데이터 공유
		request.setAttribute("su", su);
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		/* request.setAttribute("imageName", imageName); */
		// 화면 이동
    	/* RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardDeleteResult"); */
    	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardDeleteResult");
    	dispatcher.forward(request, response);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>