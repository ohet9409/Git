<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/guestScript.js"></script>
</head>
<body>
<form action="../guest/write.do" name="Frm">
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th>
				작성자
			</th>
			<td>
				<input type="text" name="name" style="width: 190px; " required="required">
			</td>
		
			<th>
				이메일
			</th>
			<td>
				<input type="email" name="email" style="width: 190px; ">
			</td>
		</tr>
		<tr>
			<th>
				제목
			</th>
			<td colspan="3">
				<input type="text" name="subject" style="width: 500px; " required="required">
			</td>
		</tr>
		<tr>
			<th>
				내용
			</th>
			<td colspan="3">
				<textarea rows="25" cols="60" name="content" required="required"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
			<input type="submit" value="입력" >
			<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>