<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	BoardDAO dao = new BoardDAO();
    	int su = dao.countHit(seq);
    	BoardDTO dto = dao.boardView(seq);
    	String id = (String)session.getAttribute("memId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 600px; border-collapse: collapse;">
		<tr>
			<td colspan="3"><%=dto.getSubject() %></td>
		</tr>
		<tr align="center">
			<td>글번호: <%=dto.getSeq() %></td>
			<td>작성자: <%=dto.getName() %></td>
			<td>조회수: <%=dto.getHit() %></td>
		</tr>
		<tr style="height: 300px;">
			<td colspan="3" valign="top"><%=dto.getContent() %></td>
		</tr>	
		<tr>
			<td colspan="3">
				<input type="button" value="목록" onclick="location.href='boardList.jsp?pg='+<%=pg%>"> 
				<%if(session.getAttribute("memId").equals(dto.getId())) {%>
				<input type="button" value="글수정" onclick="location.href='boardWriteForm.jsp?seq='+<%=dto.getSeq()%>+'&pg='+<%=pg%>">
				<input type="button" value="글삭제" onclick="location.href='boardDelete.jsp?seq='+<%=dto.getSeq()%>+'&pg='+<%=pg%>">
				<%} %>
			</td>
		</tr>
	</table>
</body>
</html>