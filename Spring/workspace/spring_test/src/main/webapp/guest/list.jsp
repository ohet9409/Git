<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#currentPaging{
	text-decoration: underline;
	color: red;
}
#Paging{
	text-decoration: none;
	color: blue;
}

#subjectA:hover {
	color: green;
	text-decoration: underline;
}
#subjectA{
	text-align: center;
}
</style>
</head>
<body>
<table border="1" style="width: 600px;">
		<tr align="center" bgcolor="yellow">
			<th width="70">글번호</th>
			<th>작성자</td>
			<th width="100">이메일</th>
			<th width="100">제목</th>
			<th width="100">내용</th>
			<th width="100">작성일</th>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr bgcolor="lightyellow" id="subjectA">
				<td>${dto.num}</td>
				<td> ${dto.name}</td>
				<td>${dto.email}</td>
				<td>${dto.subject}</td>
				<td>${dto.content}</td>
				<td>${dto.logtime}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="center">
			<c:if test="${startPage>3}">
			<a href="../guest/list.do?pg=${startPage-1 }" id ="Paging">
				[이전]
				</a>
			</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:if test="${pg == i }">
				<a href="../guest/list.do?pg=${i}" id="currentPaging">[${i}]</a> 
				</c:if>
				<c:if test="${pg != i }">
				<a href="../guest/list.do?pg=${i}" id="Paging">[${i}]</a> 
				</c:if>
				</c:forEach>
			<c:if test="${endPage < totalP }">
			<a href="../guest/list.do?pg=${endPage+1 }" id="Paging">
				[다음]
			</a>
			</c:if>
			</td>
		</tr>
	</table>


</body>
</html>