<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#paging{
	color: black;
}
#currentPaging{
	color: red;
}
</style>
</head>
<body>
	<table border="1" style="border-collapse: collapse;" width="70%" heigh="50%">
		<tr>
			<th>도서코드</th>
			<th>도서명</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:forEach var="bookDTO" items="${list}">
			<tr align="center">
				<td>${bookDTO.code} </td>
				<td>${bookDTO.book} </td>
				<td>${bookDTO.writer} </td>
				<td>${bookDTO.publisher} </td>
				<td>${bookDTO.price} </td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="center">
			<c:if test="${startPage>3 }">
				[<a href="bookList.jsp?pg=${startPage-1}" id="paging"> 이전</a>]
			</c:if>
				<c:forEach var="i" step="1" begin="${startPage}" end="${endPage}">
				<c:if test="${pg==i}">
				[<a href="../book/bookList.jsp?pg=${i}" id="currentPaging"> ${i}</a>]</c:if>
					<c:if test="${pg!=i}">
					[<a href="../book/bookList.jsp?pg=${i}" id="paging"> ${i}</a>]</c:if>
				</c:forEach>
			<c:if test="${endPage < totalP}">
				[<a href="../book/bookList.jsp?pg=${endPage+1}" id="paging">다음</a>]
			</c:if>
			</td>
		</tr>
	</table>
</body>
</html>