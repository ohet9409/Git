<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#paging { color: blue; text-decoration: none;}
#current {color: red; text-decoration: underline;}
table {
	width: 597px;	
	height: 500px;
}

</style>
</head>
<body>
<h2 align="center">성적목록</h2>
	<table border="1" style="border-collapse: collapse;">
	<tr bgcolor="lightgray">
		<th>학번</th>
		<th>이름</th>
		<th>국어점수</th>
		<th>영어점수</th>
		<th>수학점수</th>
		<th>한국사점수</th>
		<th>총점</th>
		<th>평균</th>
		</tr>
		<c:forEach var="dto" items="${list}">
		<tr>
			<td align="center">${dto.hakbun}</td>
			<td align="center">${dto.name}</td>
			<td align="center">${dto.kor}점</td>
			<td align="center">${dto.eng}점</td>
			<td align="center">${dto.mat}점</td>
			<td align="center">${dto.his}점</td>
			<td align="center">${dto.total}점</td>
			<td align="center">${dto.avg}점</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8" align="center">
			<c:if test="${startPage>3}">
			[<a href="listForm.do?pg=${startPage-1}" id="paging"> 이전</a>]
			</c:if>
			<c:forEach var="i" step="1" begin="${startPage}" end="${endPage}">
			<c:if test="${i==pg}">
			[<a href="listForm.do?pg=${i}" id = "current"> ${i}</a>]
			</c:if>
			<c:if test="${i!=pg}">
			[<a href="listForm.do?pg=${i}" id = "paging"> ${i}</a>]
			</c:if>
			</c:forEach>
			<c:if test="${endPage<totalP}">
			[<a href="listForm.do?pg=${endPage+1}" id = "paging">다음</a>]
			</c:if>
			</td>
		</tr>
	</table>
</body>
</html>