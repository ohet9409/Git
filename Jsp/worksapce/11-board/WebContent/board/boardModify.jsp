<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	int seq = Integer.parseInt(request.getParameter("seq"));
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	String subject= request.getParameter("subject");
    	String content= request.getParameter("content");
    	
		BoardDTO boardDTO = new BoardDTO();
		
    	boardDTO.setSubject(subject);
    	boardDTO.setContent(content);
    	
    	BoardDAO boardDAO = new BoardDAO();
    	int su= boardDAO.boardModify(boardDTO, seq);
    	// 저장되면 su=1 , 저장 실패시 su=0
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		<% if(su>0) {%>
		alert("작성하신 글이 수정되었습니다.");
		location.href="boardList.jsp?pg=<%=pg%>";
		<%} else { %>
		alert("수정실패");
		location.href="boardModify.jsp";
		<%} %>
		location.href="boardView.jsp?seq=<%=seq%>&pg=<%=pg%>";
		
</script>
</head>
<body>
	
	<%-- 글쓴이 : <%=name %><br>
	제목 : <%=subject %><br>
	내용 : <%=content %><br> --%>
</body>
</html>