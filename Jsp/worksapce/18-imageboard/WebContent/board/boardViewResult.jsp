<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<td colspan="3">
			<font size="5"><%-- <%=boardDTO.getSubject() %> --%>
			${boardDTO.subject}
			</font>
		</td>
	</tr>
	<tr align="center">
		<td width="150">글번호 : <%-- <%=boardDTO.getSeq() %> --%>${boardDTO.seq}</td>
		<td width="150">작성자 : <%-- <%=boardDTO.getName() %> --%>${boardDTO.name}</td>
		<td width="150">조회수 : <%-- <%=boardDTO.getHit() %> --%>${boardDTO.hit}</td>
	</tr>
	<tr>
		<td colspan="3" height="200" valign="top">
			<pre><%-- <%=boardDTO.getContent() %> --%>${boardDTO.content}</pre>
		</td>
	</tr>
</table>
<input type="button" value="목록" 
	onclick="location.href='boardList.jsp?pg=<%-- <%=pg%> --%>${pg}'">
<%-- <% if(session.getAttribute("memId").equals(/* boardDTO.getId() */${boardDTO.id)) { %>  --%>
<c:if test="session.getAttribute('memId').equals(${boardDTO.id})">
<input type="button" value="글수정" 
	onclick="location.href='boardModifyForm.jsp?seq=<%-- <%=seq% --%>>${seq}&pg=<%-- <%=pg%> --%>${pg}'">
<input type="button" value="글삭제" 
	onclick="location.href='boardDelete.jsp?seq=<%-- <%=seq%> --%>${seq}&pg=<%-- <%=pg%> --%>${pg}'">
<%-- <% } %> --%>
</c:if>
</body>
</html>