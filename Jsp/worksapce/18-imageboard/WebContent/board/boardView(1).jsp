<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	BoardDAO boardDAO = new BoardDAO();
	// 조회수 증가
	boardDAO.updateHit(seq);
	BoardDTO boardDTO = boardDAO.boardView(seq);
	// 데이터 공유
	request.setAttribute("boardDTO", boardDTO);
	request.setAttribute("seq", seq);
	request.setAttribute("pg", pg);
	 // 페이지 이동 : forward 방식 (index.jsp로 이동)
 	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=boardViewResult");
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











