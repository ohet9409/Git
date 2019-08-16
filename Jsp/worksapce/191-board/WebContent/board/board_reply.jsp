<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

form{
	margin: auto;
	width: 480px;
}
#a{
	background-color: orange;
	width: 150px;
	text-align: center;
}
</style>
</head>
<body>
<h2 align="center">답글 등록</h2>
<form action="boardReplyPro.do?pg=${param.pg}&board_num=${param.board_num}&board_re_seq=${param.board_re_seq}&board_re_ref=${param.board_re_ref}&board_re_lev=${param.board_re_lev}" style="width: 480px; "method="post" name="boardForm">
<input type="hidden" value="${pg}" name="pg">
<input type="hidden" value="${board_num}" name="board_num">
<input type="hidden" value="${boardBean.board_re_lev}" name="board_re_lev2">
	<table>
		<tr>
			<td id="a">글쓴이</td>
			<td bgcolor="skyblue"><input type="text" name="board_name" required="required" > </td>
		</tr>
		<tr>
			<td id="a">비밀번호</td>
			<td bgcolor="skyblue"><input type="password" name="board_pass" required="required"> </td>
		</tr>
		<tr>
			<td id="a">제목</td>
			<td bgcolor="skyblue"><input type="text" name="board_subject" required="required" > </td>
		</tr>
		<tr>
			<td id="a">내용</td>
			<td bgcolor="skyblue"><textarea rows="15" cols="45" name="board_content" required="required"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="답변글등록">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>