<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	// 데이터
    	request.setCharacterEncoding("utf-8");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int seq = Integer.parseInt(request.getParameter("seq"));
		// DB
		ImageboardDTO imageboardDTO = new ImageboardDTO();
		ImageboardDAO imageboardDAO = new ImageboardDAO();
		imageboardDTO= imageboardDAO.imageboardView(seq);
		// 데이터 공유
		request.setAttribute("imageboardDTO", imageboardDTO);
		request.setAttribute("pg", pg);
		request.setAttribute("seq", seq);
		// 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyForm");
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