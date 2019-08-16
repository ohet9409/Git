<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	margin: auto;
	width: 480px;
}
th{
	background-color: orange;
}
#currentPaging{
	color: red;
	text-decoration: underline;
}
#paging{
	color: blue;
	text-decoration: none;
}
</style>
</head>
<body>
<h2 align="center">글 목록</h2>
<div id="listForm">
<table border="1" style="border-collapse: collapse; width: 480px;">
	<tr id="tr_top">
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<!-- 목록 -->
	<c:forEach var="boardBean" items="${list}">
		<tr>
			<td>${boardBean.board_num}</td>
			<td>
			<!-- 답글 들여쓰기 -->
			<c:if test="${boardBean.board_re_lev != 0}">
				<c:forEach var="a" begin="0" end="${boardBean.board_re_lev*2}" step="1">
				&nbsp;
				</c:forEach>
			</c:if>	
			<a href="boardDetail.do?board_num=${boardBean.board_num}&pg=${pg}">
			▶${boardBean.board_subject}</a>
			</td>
			<td>${boardBean.getBoard_name()}</td>
			<td>${boardBean.getBoard_date()}</td>
			<td>${boardBean.getBoard_readcount()}</td>
		</tr>
	</c:forEach>
	<!-- 페이징 -->
		<tr>
			<td colspan="5" align="center">
			<c:if test="${startPage>3 }">
				[<a href="boardList.do?pg=${startPage-1}" id="paging">이전</a>]
			</c:if>
		<c:forEach var="i" step="1" begin="${startPage}" end="${endPage}">
		<c:if test="${i==pg}">
			[<a href="boardList.do?pg=${i}" id="currentPaging"> ${i}</a>]
			</c:if>
		<c:if test="${i!=pg}">
			[<a href="boardList.do?pg=${i}" id="paging"> ${i}</a>]
		</c:if>
		</c:forEach>	
		<c:if test="${endPage<totalP}">	
				[<a href="boardList.do?pg=${endPage+1}" id="paging">다음</a>]
			</c:if>
			</td>
		</tr>
</table>
</div>
<a href="index.jsp">메인 화면</a>&nbsp;&nbsp;&nbsp;
<a href="boardWriteForm.do">게시판 글쓰기</a>
</body>
</html>