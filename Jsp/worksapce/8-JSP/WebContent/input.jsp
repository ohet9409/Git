<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="result.jsp" method="post">
	<table border="1">
		<tr align="center">
			<td width="50"><label>X</label> </td>
			<td><input type="text" name="x"></td>
		</tr>
		<tr align="center">
			<td><label>Y</label> </td>
			<td><input type="text" name="y"></td>
		</tr>
		<tr align="center">
			<td colspan="2"> 
			<input type="submit" value="계산">
			<input type="submit" value="원래대로">
			</td>
		</tr>
	</table>
</form>
</body>
</html>