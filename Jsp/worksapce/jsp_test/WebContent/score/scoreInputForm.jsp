<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
<script type="text/javascript" src="../script/score.js"></script>
</head>
<body>
<form action="scoreInput.jsp" method="post" name="inputForm">
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th><label>학번</label></th>
			<td><input type="text" name="hakbun"> </td>
		</tr>
		<tr>
			<th><label>이름</label></th>
			<td><input type="text" name="name"> </td>
		</tr>
		<tr>
			<th><label>국어점수</label></th>
			<td><input type="text" name="kor"> </td>
		</tr>
		<tr>
			<th><label>영어점수</label></th>
			<td><input type="text" name="eng"> </td>
		</tr>
		<tr>
			<th><label>수학점수</label></th>
			<td><input type="text" name="mat"> </td>
		</tr>
		<tr align="center">
			<td colspan="2"> 
				<input type="button" value="성적입력" onclick="input()">
				<input type="reset" value="다시입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>