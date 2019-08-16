<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 인증</title>
<script type="text/javascript" src="check.js">

</script>
</head>
<body>
<h1>회원 인증 화면</h1>
<form action="exam9Pro.jsp" method="get" name="frm">
	<table>
		<tr>
		<td><label>ID:</label></td>
		<td><input type="text" name="id"> </td>
		</tr>
		<tr>
		<td><label>PW:</label></td>
		<td><input type="password" name="pw"> </td>
		</tr>
	</table>
	<input type="button" value="확인" onclick="chekInput()">
</form>
</body>
</html>