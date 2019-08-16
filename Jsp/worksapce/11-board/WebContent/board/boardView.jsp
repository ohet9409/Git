<%@page import="member.bean.MemberDTO"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	BoardDTO dto = new BoardDTO();
    	BoardDAO dao = new BoardDAO();
    	String id = (String)session.getAttribute("memId");
    	//조회수 증가
    	dao.updateHit(seq);
    	dto=dao.boardView(seq);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js">
	function deleteA(){
		if(confirm("삭제?")){
			location.href="boardDelete.jsp?isDel=true&seq=<%=seq%>&pg=<%=pg%>";
		}else{
			location.href="boardDelete.jsp?isDel=false&seq=<%=seq%>&pg=<%=pg%>";
		}
	}
</script>
<style type="text/css">
td{
	padding-top: 5px;
	padding-bottom: 5px;
}
#subject{
	padding-left: 5px;
}
#content{
	vertical-align: top;
	padding-top: 10px;
	padding-left: 5px;
}
</style>
</head>
<body>
<form>
	<table border="1" style="border-collapse: collapse;">
		<tr>
		<td colspan="3" id="subject"><%=dto.getSubject() %></td>
		</tr>
		<tr>
		<td width="150" align="center">글번호: <%=seq %></td>
		<td width="150" align="center">작성자: <%=dto.getName() %></td>
		<td width="150" align="center">조회수: <%=dto.getHit() %></td>
		</tr>
		<tr>
		<td colspan="3" height="150" id="content"><%=dto.getContent() %></td>
		</tr>
	</table>
	<input type="button" value="목록" onclick= "location.href='boardList.jsp?pg=<%=pg%>'">
		<%if(id.equals(dto.getId())) {%>
		<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=seq%>&pg=<%=pg%>'">
		<input type="button" value="글삭제" onclick="deleteA()">	
		<%} %>
	</form>
</body>
</html>