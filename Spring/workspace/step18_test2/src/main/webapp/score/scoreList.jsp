<%@page import="score.dao.ScoreDAO"%>
<%@page import="java.util.List"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 목록</title>
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
	background-color: orange;
	color: green;
	text-decoration: underline;
}
div{
	width: 500px;
	margin: auto;
}
table{
	width: 500px;
	margin: auto;
}
td{
	text-align: center;
}
</style>
</head>
<body>
	<h2 align="center">성적 목록</h2>
	<div>
	<table>
		<tr bgcolor="orange">
			<td>학번</td>
			<td>이름</td>
			<td>국어</td>
			<td>영어</td>
			<td>수학</td>
			<td>총점</td>
			<td>평균</td>
		</tr>
		<c:forEach var="dto" items="${list}" >
			<tr bgcolor="lightyellow" id="subjectA">
				<td><a href="scoreView.do?studNo=${dto.studNo}&pg=${pg}">${dto.studNo}</a></td>
				<td> ${dto.name}</td>
				<td>${dto.kor}</td>
				<td>${dto.eng}</td>
				<td>${dto.mat}</td>
				<td>${dto.tot}</td>
				<td>${dto.avg}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7" align="center">
			<c:if test="${startPage>3}">
			<a href="scoreList.do?pg=${startPage-1 }" id ="Paging">
				[이전]
				</a>
			</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i }">
				<a href="scoreList.do?pg=${i}" id="currentPaging">[${i}]</a> 
				</c:if>
				<c:if test="${pg != i }">
				<a href="scoreList.do?pg=${i}" id="Paging">[${i}]</a> 
				</c:if>
				</c:forEach>
			<c:if test="${endPage < totalP }">
			<a href="scoreList.do?pg=${endPage+1 }" id="Paging">
				[다음]
			</a>
			</c:if>
			</td>
		</tr>
	</table>
	<input type="button" value="성적입력" onclick="location.href='scoreWriteForm.do'">
	</div>
</body>
</html>