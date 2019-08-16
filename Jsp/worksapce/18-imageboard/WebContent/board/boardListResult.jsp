<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function isLogin(seq) {
		<% if(session.getAttribute("memId") == null) { // 로그아웃 상태%>
				alert("먼저 로그인 하세요.");
				location.href="../main/index.jsp";
		<% } else { // 로그인 상태 %>
				location.href="boardView.jsp?seq=" + seq + "&pg="+${pg};
		<% } %>
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

#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:achive {color: black; text-decoration: none;}
#subjectA:hover {color: blue; text-decoration: underline;}
</style>
</head>
<body>
<table border="1">
	<tr bgcolor="#ffff00">
		<th width="70">글번호</th>
		<th width="200">제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="70">조회수</th>
	</tr>
<%-- for(int i=0; i<list.size(); i++) { 
	BoardDTO boardDTO = list.get(i);
--%>
<%-- <% for(BoardDTO boardDTO : list) { %>	 --%>
<c:forEach var="boardDTO" items="${list}">
	<tr bgcolor="#ffffcc" align="center">
		<td><%-- <%=boardDTO.getSeq() %> --%>
		${boardDTO.seq}
		</td>
		<td><a id="subjectA" href="#" onclick="isLogin(<%-- <%=boardDTO.getSeq() %> --%>${boardDTO.seq})">
			<%-- <%=boardDTO.getSubject() %> --%>${boardDTO.subject}
			</a>
		</td>
		<td><%-- <%=boardDTO.getName() %> --%>${boardDTO.name}</td>
		<td><%-- <%=boardDTO.getLogtime() %> --%>${boardDTO.logtime}</td>
		<td><%-- <%=boardDTO.getHit() %> --%>${boardDTO.hit}</td>
	</tr>
</c:forEach>
	<tr>
		<td colspan="5" align="center">
		<%-- <% if(startPage > 3) { %> --%>
		<c:if test="${startPage >3}">
			[<a id="paging" href="boardList.jsp?pg=<%-- <%=startPage-1 %> --%>${startPage-1}">이전</a>]
		<%-- <% } %> --%>
			</c:if>
		<%-- <% for(int i=startPage; i<=endPage; i++) { %> --%>
		<%-- 	<%if(pg==i) { %> 	 --%>
		<c:forEach var="i"  step="1" begin="${startPage }" end="${endPage}">
			<c:if test="${pg==i}">
			[<a id="currentPaging" href="boardList.jsp?pg=<%-- <%=i %> --%>${i}"><%-- <%=i %> --%>${i}</a>]
			</c:if>
			<%-- <% } else { %> --%>
			<c:if test="${pg!=i}">
			[<a id="paging" href="boardList.jsp?pg=<%-- <%=i %> --%>${i}"><%-- <%=i %> --%>${i}</a>]	
			</c:if>
		<%-- 	<% } %>
		<% } %> --%>
		</c:forEach>
				<c:if test="${endPage < totalP}">
		
		<%-- <% if(endPage < totalP) { %> --%>
		<c:if test="${endPage < totalP}">
			[<a id="paging" href="boardList.jsp?pg=${endPage+1 }<%-- <%=endPage+1%> --%>">다음</a>]
			</c:if>
		<%-- <% } %> --%>
		</c:if>
		</td>
	</tr>
</table>
<a href="../main/index.jsp">메인 화면</a>&nbsp;&nbsp;
<a href="../main/index.jsp?req=boardWriteForm.jsp">글쓰기</a>
</body>
</html>