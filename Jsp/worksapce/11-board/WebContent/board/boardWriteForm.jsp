<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript" src="../script/boardScript.js">
</script>
</head>
<body>
<form action="boardWrite.jsp" name="frm"  method="post">
<table border="1" style="margin: auto;">
	<tr>
	<th>제목</th>
	<td>
	<input type="text" size=59 name="subject">
	</td>
	</tr>
	<tr>
	<th>내용</th>
	<td>
	<textarea rows="15" cols="45" name="content"></textarea>
	</td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="button" value="글쓰기" onclick="input()">
	<input type="reset" value="다시작성">
	</td>
	</tr>
</table>
</form>
</body>
</html>