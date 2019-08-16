<%@page import="java.util.List"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	// 데이터 처리
    	int pg = 1;
    	if(request.getParameter("pg") != null){
    		pg = Integer.parseInt(request.getParameter("pg"));
    	}
    	// 목록처리 (5줄씩)
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	
    	BoardDAO dao = new BoardDAO();
    	List<BoardDTO> list = dao.boardList(startNum, endNum);
    
    	// 페이징 처리
    	int count = dao.count();	// 총목록수
    	int totalP = (count+4)/5;	// 총 페이지수
    	
    	int startPage = (pg-1)/3*3+1;
    	int endPage = startPage+2;
    	if(endPage > totalP){
    		endPage = totalP;
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript">
	function isLogin(seq) {
		<% if(session.getAttribute("memId") == null){ %>
			alert("로그인 먼저하세요");
			location.href = "../member/loginForm.jsp";
		<% } else { %>
			location.href = "boardView.jsp?seq="+seq+"&pg="+<%=pg%>;
		<% } %>
	}
</script>
<style type="text/css">
#currentPaging{
	text-decoration: underline;
	color: red;
}
#Paging{
	text-decoration: none;
	color: blue;
}
#subjectA:link {
	color: black;
	text-decoration: none;
}
#subjectA:active {
	color: black;
	text-decoration: none;
}
#subjectA:visited {
	color: black;
	text-decoration: none;
}
#subjectA:hover {
	color: green;
	text-decoration: underline;
}
</style>
</head>
<body>
<form action="">
	<table border="1" style="width: 500px;">
		<tr align="center" bgcolor="yellow">
			<td width="70">글번호</td>
			<td>제목</td>
			<td width="100">작성자</td>
			<td width="100">작성일</td>
			<td width="70">조회수</td>
		</tr>
		<%for(BoardDTO dto : list){ %>
		<tr align="center">
			<td><%=dto.getSeq() %> </td>
			<td><a id="subjectA" href="#" onclick="isLogin(<%=dto.getSeq()%>)"><%=dto.getSubject() %></a> </td>
			<td><%=dto.getId() %> </td>
			<td><%=dto.getLogtime() %> </td>
			<td><%=dto.getHit() %> </td>
		</tr>
		<%} %>
		<tr align="center">
		<td colspan="5">
		<%if(startPage > 3) {%>
		<a href="boardList.jsp?pg=<%=startPage-1 %>" id="Paging">
			[이전]
		</a>
		<%} %>
			<%for(int i=startPage; i<=endPage; i++) {%>
				<%if(pg == i) {%>
					<a href="boardList.jsp?pg=<%=i %>" id="currentPaging"> [<%=i %>]</a>
				<%} else { %>
					<a href="boardList.jsp?pg=<%=i %>" id="Paging"> [<%=i %>]</a>
				<%} %>
			<%} %>
		<%if(endPage < totalP) {%>
		<a href="boardList.jsp?pg=<%=endPage+1 %>" id="Paging">
			[다음]</a>
		<%} %>
		</td>
		</tr>
	</table>
	<a href="boardWriteForm.jsp">새글쓰기</a>
</form>
</body>
</html>