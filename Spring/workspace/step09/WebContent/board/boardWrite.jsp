<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String id = (String)session.getAttribute("memId");
    	String name = (String)session.getAttribute("memName");
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    	BoardDTO dto = new BoardDTO();
    	dto.setContent(content);
    	dto.setId(id);
    	dto.setName(name);
    	dto.setSubject(subject);
    	BoardDAO dao = new BoardDAO();
    	int su = dao.boardWrite(dto);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		<%if(su>0){%>
			alert("저장성공")
			location.href="boardList.jsp";
		<%} else {%>
			alert("저장실패")
			history.back();
		<%}%>
	</script>
</head>
<body>

</body>
</html>