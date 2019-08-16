<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String name = (String)session.getAttribute("memName");
    	String id = (String)session.getAttribute("memId");
    	String subject= request.getParameter("subject");
    	String content= request.getParameter("content");
    	
		BoardDTO boardDTO = new BoardDTO();
		
    	boardDTO.setId(id);
    	boardDTO.setName(name);
    	boardDTO.setSubject(subject);
    	boardDTO.setContent(content);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	int su= boardDAO.boardWrite(boardDTO);
    	// 저장되면 su=1 , 저장 실패시 su=0
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		<% if(su>0) {%>
		alert("작성하신 글이 저장되었습니다.");
		<%} else { %>
		alert("저장실패");
		<%} %>
		location.href="../main/index.jsp";
</script>
</head>
<body>
	
	<%-- 글쓴이 : <%=name %><br>
	제목 : <%=subject %><br>
	내용 : <%=content %><br> --%>
</body>
</html>