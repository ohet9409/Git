<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	// 데이터 처리
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	// 목록 5개씩 끊어서 가져오기
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	ImageboardDAO dao = new ImageboardDAO();
    	List<ImageboardDTO> list = dao.imageList(startNum, endNum);
    	// 페이징 처리
    	/* 
    		한 페이지의 목록의 갯수: 5줄
    		총 글수: 12
    		총페이지: 3
    		총 글수: 23
    		총 페이지수: 5
    		총페이지수= (총글수+4)/5
    	*/
    	int totalA = dao.totalA();		// 총 글수
    	int totalP = (totalA+4)/5;		// 총페이지수
    	/* 
    		페이지 표시: 3블럭
    		총페이지 수: 8
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
    	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
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