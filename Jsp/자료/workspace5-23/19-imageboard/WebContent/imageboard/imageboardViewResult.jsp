<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 게시판</title>
</head>
<body>
<table border="1">
	<tr>
		<td rowspan="4">
			<img alt="이미지" src="../storage/${imageboardDTO.image1 }"
				width="150" height="150">
		</td>
		<td width="200">상품명 : ${imageboardDTO.imageName}</td>
	</tr>
	<tr>
		<td>단가 : ${imageboardDTO.imagePrice }</td>
	</tr>
	<tr>
		<td>개수 : ${imageboardDTO.imageQty }</td>
	</tr>
	<tr>
		<td>합계 : ${imageboardDTO.imagePrice * imageboardDTO.imageQty}</td>
	</tr>
	<tr>
		<td colspan="2" height="200" valign="top">
			<pre>${imageboardDTO.imageContent}</pre>
		</td>
	</tr>
</table>
<input type="button" value="이전목록" 
 	onclick="location.href='imageboardList.jsp?pg=${pg}'"> 
<input type="button" value="삭제" 
	onclick="location.href='imageboardDelete.jsp?seq=${seq}'">
<form action="imageboardDelete.jsp" method="post" 
		style="display: inline-block;">
	<input type="hidden" name="seq" value="${seq}">
	<input type="hidden" name="imageName" value="${imageboardDTO.imageName}">
	<input type="submit" value="삭제2">
</form>
<input type="button" value="수정" 
	onclick="location.href='imageboardModifyFormReady.jsp?seq=${seq}&pg=${pg}'"> 	
</body>
</html>















