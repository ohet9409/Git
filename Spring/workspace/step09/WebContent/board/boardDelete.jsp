<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	
    	BoardDAO dao = new BoardDAO();
    	int su = dao.boardDelete(seq);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%if(su>0){%>
		alert("삭제성공");
		location.href = "boardList.jsp?pg="+<%=pg%>;
	<%}else{%>
		alert("삭제실패")
		history.back();
	<%}%>
</script>
</head>
<body>
</body>
</html>