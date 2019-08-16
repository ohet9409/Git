<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판</title>
<style type="text/css">
#currentPaging { color: red; text-decoration: underline;}
#paging { color: blue; text-decoration: none;}
</style>
</head>
<body>
<table border="1">
	<tr>
		<th width="100">번호</th>
		<th width="150">이미지</th>
		<th width="150">상품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>
	</tr>
<c:forEach var="imageboardDTO" items="${requestScope.list}">
	<tr align="center">
		<td>${imageboardDTO.seq}</td>	<%-- <%=imageboardDTO.getSeq()%>와 동일  --%>
		<td><a href="imageboardView.jsp?seq=${imageboardDTO.seq}&pg=${pg}">
			<img alt="이미지" src="../storage/${imageboardDTO.image1}" 
				width="50" height="50">
		</a></td>
		<td>${imageboardDTO.imageName}</td>
		<td>${imageboardDTO.imagePrice}</td>
		<td>${imageboardDTO.imageQty}</td>
		<td>${imageboardDTO.imagePrice * imageboardDTO.imageQty}</td>
	</tr>
</c:forEach>

	<!-- 페이징 처리 -->
	<tr>
		<td colspan="6" align="center">
		<c:if test="${startPage > 3}">
			[<a id="paging" href="imageboardList.jsp?pg=${startPage-1}">이전</a>]
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage }" step="1">
			<c:if test="${i == pg}">	<!-- 현재 페이지 -->
				[<a id="currentPaging" href="/17-imageboard/imageboard/imageboardList.jsp?pg=${i}">${i}</a>]
			</c:if>
			<c:if test="${i != pg}">
				[<a id="paging" href="/17-imageboard/imageboard/imageboardList.jsp?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>	
			
		<c:if test="${endPage < totalP}">
			[<a id="paging" href="imageboardList.jsp?pg=${endPage+1}">다음</a>]
		</c:if>
		</td>
	</tr>
</table>
</body>
</html>






