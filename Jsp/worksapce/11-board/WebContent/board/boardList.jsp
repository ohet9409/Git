<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String id = (String)session.getAttribute("memId");
    	int pg = Integer.parseInt(request.getParameter("pg"));
    	// 5개씩 목록 보여주기
    	// (1,5), (6,10), (11,15), (16,20)
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	BoardDAO boardDAO = new BoardDAO();
    	List<BoardDTO> list = boardDAO.boardList(startNum,endNum);
    	// 페이징 처리(목록은 5줄 씩 끊어서 보여줌)
    	// 총 페이지 수 = (총글수 + 4)/5
    	// 총 글수 : 12
    	// 총 페이지수: 3  [1][2][3]
        
    	// 총 글수 : 23
    	// 총 페이지수: 5  [1][2][3][4][5]
    	int totalA = boardDAO.getTotalA();	// 총 글수
    	int totalP = (totalA + 4) /5;		// 총 페이지 수
    	/*
    	페이지는 3개씩 끊어서 보여줌
    	총 페이지 수 : 8
    	[1][2][3][다음]
    	[이전][4][5][6][다음]
    	[이전][7][8]
    			int startPage = (pg-1)/10*10+1 ; 10개씩*/
    	int startPage = (pg-1)/3*3+1 ;	//3 개씩
    	int endPage = startPage + 2;
    	if(totalP < endPage){
    		endPage = totalP;
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq) {
		<% if(id == null) { // 로그 아웃 상태%>
			alert("먼저 로그인 해주세요");
			location.href="../member/loginForm.jsp";
		<%} else {  // 로그인 상태%>
			location.href="boardView.jsp?seq="+ seq +"&pg="+<%=pg%>;	/* seq: 해당 제목의 번호값을 set이란 이름으로 보내줌 */
		<%}%>
	}
</script>
<style type="text/css">
 #paging {
 	color: blue;
 	text-decoration: none;
 }
 #currentPaging {
 	color: red;
 	text-decoration: underline;
 }
 
 #subjectA:link {	/* 보여줄때 */
	color: red;
	text-decoration: none;
}
 #subjectA:visited {	/* 방문했던 */
	color: magenta;
	text-decoration: none;
}
 #subjectA:active {	/* 클릭 시 */
	color: yellow;
	text-decoration: none;
}
 #subjectA:hover { /* 마우스를 올려놓을때 */
	color: blue;
	text-decoration: underline;
}
</style>
</head>
<body>
	<table border="1">
		<tr bgcolor="yellow">
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		</tr>
		<%-- <% for(int i=0; i<list.size(); i++) {%>
		<%BoardDTO dto = list.get(i); %> --%>
		<% for(BoardDTO dto : list){ %>
			<tr align="center" bgcolor="lightyellow">
				<td width="100" height="10"><%=dto.getSeq() %></td>
				<td width="250" height="10"><a href="#" id="subjectA" onclick="isLogin(<%= dto.getSeq()%>)"><%=dto.getSubject() %></a></td>
				<td width="100" height="10"><%=dto.getId() %></td>
				<td width="250" height="10"><%=dto.getLogtime() %></td>
				<td width="50" height="10"><%=dto.getHit() %></td>		
			</tr>
		<%} %>
		<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
				<%if(startPage>3){ %>
				[<a id="paging" href="boardList.jsp?pg=<%=startPage-1%>">이전</a>]
				<%} %>
				<% for(int i=startPage; i<=endPage; i++){ %>
				<%if(pg==i) {%>
					[<a id="currentPaging" href="boardList.jsp?pg=<%=i%>"><%=i %></a>]
					<%}else{ %>
					[<a id="paging" href="boardList.jsp?pg=<%=i%>"><%=i %></a>]
					<%} %>
				<%} %>
				<%if(endPage < totalP){ %>
				[<a id="paging" href="boardList.jsp?pg=<%=endPage+1%>">다음</a>]
				<%} %>
			</td>
		</tr>
	</table>
	<a href="../main/index.jsp">메인화면</a>&nbsp;&nbsp;
	<a href="boardWriteForm.jsp">글쓰기</a>
</body>
</html>