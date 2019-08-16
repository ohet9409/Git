<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form{
	margin:auto;
	border: solid 1px orange;
	width: 300px;
}
</style>
</head>
<body>
<form action="boardDeletePro.do" method="post">
<input type="hidden" value="${param.pg}" name="pg">
<input type="hidden" value="${param.board_num}" name="board_num">
	글 비밀번호:&nbsp;&nbsp;&nbsp;
	<input type="password" name="pass" required="required"><br>
	<input type="submit" value="삭제">
	<input type="button" value="돌아가기" onclick="history.back(-1);">
</form>
</body>
</html>