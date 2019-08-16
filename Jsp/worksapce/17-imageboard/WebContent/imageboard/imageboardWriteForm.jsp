<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/imageboardScript.js">

</script>
<style type="text/css">

th{
	padding-left: 10px;
	padding-right: 10px;
	
}
</style>
</head>
<body>
<h3>이미지등록</h3>
<form action="../imageboard/imageboardWrite.jsp" method="post" enctype="multipart/form-data" name="writeForm">
<table border="1" style="border-collapse: collapse;">
<tr>
<th>상품코드</th>
<td><input type="text" style="width: 340px;" name="imageId"></td>
</tr>
<tr>
<th>상품명</th>
<td><input type="text" style="width: 340px; "name="imageName"></td>
</tr>
<tr>
<th>단가</th>
<td><input type="text" style="width: 340px; "name="imagePrice"></td>
</tr>
<tr>
<th>개수</th>
<td><input type="text" style="width: 340px; "name="imageQty"></td>
</tr>
<tr>
<th>내용</th>
<td><textarea rows="10" cols="40" name="imageContent"></textarea></td>
</tr>
<tr>

<td colspan="2"><input type="file" style="width: 433px; " name="image1"></td>
</tr>
<tr align="center">
<td colspan="2"><input type="button" value="이미지등록" onclick="input()"><input type="reset" value="다시작성"></td>
</tr>
</table>
</form>
</body>
</html>