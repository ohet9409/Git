<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/write.js"></script>
<style type="text/css">
	table {
	margin: auto;
	
}
th, td{
	padding: 5px;
}
</style>
</head>
<body>
<h2 align="center"> 도서 입력</h2>
<form action="../book/book.jsp" method="post"  name="writeForm">
	
	<table style="border-collapse: collapse;" border="1">
		<tr>
			<th>도서코드</th>
			<td><input type="text" name="code" id="a"></td>
		</tr>
		<tr>
			<th>도서명</th>
			<td ><input type="text" name="book" id="a"></td>
		</tr>
		<tr style="height: 48px; ">
			<th>저자</th>
			<td><input type="text" name="writer" id="a"></td>
		</tr>
		<tr>
			<th>출판사</th>
			<td ><input type="text" name="publisher" id="a"></td>
		</tr>
		<tr>
			<th>가격</th>
			<td><input type="text" name="price" id="a"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" onclick="input()" value="입력">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>