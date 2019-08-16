<%@page import="book.dao.BookDAO"%>
<%@page import="book.Bean.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int code = Integer.parseInt(request.getParameter("code"));
    	String book = request.getParameter("book");
    	String writer = request.getParameter("writer");
    	String publisher = request.getParameter("publisher");
    	int price=0;
    	if(request.getParameter("price")!=""){
    		 price = Integer.parseInt(request.getParameter("price"));	
    	}
    	
    	
    	BookDTO dto = new BookDTO();
    	dto.setCode(code);
    	dto.setBook(book);
    	dto.setWriter(writer);
    	dto.setPublisher(publisher);
    	dto.setPrice(price);
    	
    	BookDAO dao = new BookDAO();
    	int su = dao.write(dto);
    	
    	request.setAttribute("su", su);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=bookResult");
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