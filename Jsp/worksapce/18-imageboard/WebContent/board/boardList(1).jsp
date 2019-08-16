<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));
	// 5개씩 목록 보여주기
	// (1, 5)
	// (6, 10)
	// (11, 15)
	// (16, 20)	
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	BoardDAO boardDAO = new BoardDAO();
	List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
	
	/* 페이징 처리 (목록은 5줄 씩)
	      총페이지 수 = (총글수 + 4)/5
	    총글수 : 12
	    총페이지수:3		[1][2][3]
	  
	    총글수 : 23
	    총페이지수:5		[1][2][3][4][5]
	*/
	int totalA = boardDAO.getTotalA();	// 총글수
	int totalP = (totalA + 4) / 5;	// 총페이지수
	/* 페이지는3개씩 끊어서 보여줌
		총페이지수 : 8
			 [1][2][3][다음]
		[이전][4][5][6][다음]
		[이전][7][8]
	*/
	int startPage = (pg-1)/3*3 + 1;	
	int endPage = startPage + 2;
	if(totalP < endPage) endPage = totalP;
	// 데이터 공유
	request.setAttribute("list", list);
	request.setAttribute("totalA", totalA);
	request.setAttribute("totalP", totalP);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	request.setAttribute("pg", pg);
	// 페이지 이동 : forward 방식 (index.jsp로 이동)
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=boardListResult");
	dispatcher.forward(request, response);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>

</head>
<body>

</body>
</html>











