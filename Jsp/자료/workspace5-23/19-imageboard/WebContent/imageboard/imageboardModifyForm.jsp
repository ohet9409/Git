<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 수정</title>
<script type="text/javascript" src="../script/imageboardScript.js"></script>
</head>
<body>
<h3>이미지 수정</h3>
<form action="../imageboard/imageboardModify.jsp" method="post" 
	enctype="multipart/form-data" name="frm">
	<input type="hidden" name="seq" value="${seq}">
	<input type="hidden" name="pg" value="${pg}">
	<table border="1" style="width: 400px;">
		<tr>
			<th width="100">상품코드</th>
			<td><input type="text" name="imageId" value="${imageboardDTO.imageId}" 
				size="45">
			</td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><input type="text" name="imageName" size="45"
					value="${imageboardDTO.imageName}"></td>
		</tr>
		<tr>
			<th>단가</th>
			<td><input type="text" name="imagePrice" size="45"
					value="${imageboardDTO.imagePrice}"></td>
		</tr>
		<tr>
			<th>개수</th>
			<td><input type="text" name="imageQty" size="45"
					value="${imageboardDTO.imageQty}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="35" 
				name="imageContent">${imageboardDTO.imageContent}
				</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="image1" size="45">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="이미지 수정" 
					onclick="checkImageboardWrite()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>










