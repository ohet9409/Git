<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = (String)session.getAttribute("memId");
    	request.setCharacterEncoding("utf-8");
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	BoardDTO dto= new BoardDTO();
    	BoardDAO dao = new BoardDAO();
    	dto=dao.boardView(seq);
    	String subject = dto.getSubject();
    	String content = dto.getContent();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js">

</script>
</head>
<body>
<!-- 
	* 자바 데이터를 다음 페이지로 전달하는 방법1 : get 방식 사용
	<%-- <form action="boardModify.jsp?seq=<%=seq%>&pg=<%=pg%>"> --%>
	* 자바 데이터를 다음 페이지로 전달하는 방법2 : <input> 태그 사용 -- post방식
	<%-- <input type ="hidden" name="seq" value = "<%=seq%>"> --%>
	<%-- <input type ="hidden" name="pg" value = "<%=pg%>"> --%>
 -->
 <h2 align="center">글수정</h2>
<form action="boardModify.jsp" name="boardModifyForm"  method="post">
	<input type="hidden" name="seq" value="<%=seq%>">
	<input type="hidden" name="pg" value="<%=pg%>">
<table border="1" style="margin: auto;">
	<tr>
	<th>제목</th>
	<td>
	<input type="text" size=59 name="subject" value="<%=subject%>">
	</td>
	</tr>
	<tr>
	<th>내용</th>
	<td>
	<textarea rows="15" cols="45" name="content"><%=content%></textarea>
	</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="button" value="글수정" onclick="checkBoardModify()">
	<input type="reset" value="다시작성">
	</td>
	</tr>
</table>
</form>
</body>
</html>