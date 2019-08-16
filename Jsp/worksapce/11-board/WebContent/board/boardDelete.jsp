<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Boolean isDel = Boolean.valueOf(request.getParameter("isDel"));
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	BoardDAO boardDAO = new BoardDAO();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%if(isDel){ %>
	<%boardDAO.boardDelete(seq);%>
	alert("삭제 완료");
	location.href="boardList.jsp?pg=<%=pg%>";
	<%} else { %>
	alert("삭제실패");
	location.href="boardView.jsp?seq=<%=seq%>&pg=<%=pg%>";
	<%} %>
	
</script>
</head>
<body>
	
</body>
</html>