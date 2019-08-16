<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js">
</script>
</head>
<body>
<form action="boardWrite.jsp" method="post" name="boardWriteForm">
	<table border="1" style="width: 500px">
		<tr>
			<td width="100px">제목</td>
			<td>
				<input type="text" name="subject" style="width: 400px">
			</td>
		</tr>
		<tr>
			<td width="100px">내용</td>
			<td>
				<textarea rows="20"  name="content" style="width: 400px; "></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글쓰기" onclick="checkBoardWrite()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>