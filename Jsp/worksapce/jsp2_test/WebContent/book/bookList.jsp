<%@page import="java.util.List"%>
<%@page import="book.dao.BookDAO"%>
<%@page import="book.Bean.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	int endNum = pg*10;
    	int startNum = endNum-9;
    	BookDAO dao = new BookDAO();
    	List<BookDTO> list = dao.list(startNum, endNum);
    	
    	int total = dao.total();
    	int totalP = (total+9)/10;
    	int startPage = (pg-1)/3*3+1;
    	int endPage = startPage+2 ;
    	if(totalP<endPage)
    		endPage=totalP;
    	
    	request.setAttribute("list", list);
    	request.setAttribute("total", total);
    	request.setAttribute("totalP", totalP);
    	request.setAttribute("startPage", startPage);
    	request.setAttribute("endPage", endPage);
    	request.setAttribute("pg", pg);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=bookListResult");
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