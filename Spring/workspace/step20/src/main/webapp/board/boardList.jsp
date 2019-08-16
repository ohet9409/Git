<%@page import="java.util.List"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<script type="text/javascript">
	function isLogin(seq) {
		if(${memId == null}) {
			alert("로그인 먼저하세요");
			location.href = "../member/loginForm.jsp";
		} else {
			location.href = "../board/boardView.do?seq="+seq+"&pg="+${pg};
		}
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
		<c:forEach var="dto" items="${list}">
		<tr align="center" bgcolor="ffffcc">
			<td>${dto.seq} </td>
			<td><a id="subjectA" href="#" onclick="isLogin(${dto.getSeq()})">${dto.getSubject()}</a> </td>
			<td>${dto.getId()} </td>
			<td>${dto.getLogtime()} </td>
			<td>${dto.getHit()} </td>
		</tr>
		</c:forEach>
		<tr align="center">
		<td colspan="5">
		<c:if test="${startPage>3}">
		<a href="../board/boardList.do?pg=${startPage-1 }" id="Paging">
			[이전]
		</a>
	
		</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i }">
					<a href="../board/boardList.do?pg=${i}" id="currentPaging"> [${i}]</a>
				</c:if>
				<c:if test="${pg != i }">
					<a href="../board/boardList.do?pg=${i}" id="Paging"> [${i}]</a>
				</c:if>
			</c:forEach>
		<c:if test="${endPage < totalP}">
		<a href="../board/boardList.do?pg=${endPage+1}" id="Paging">
			[다음]</a>
		</c:if>
		</td>
		</tr>
	</table>
	<a href="../board/boardWriteForm.do">새글쓰기</a>
</form>
</body>
</html>