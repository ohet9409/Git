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
<h2 align="center">게시판 글 수정</h2>
<form action="boardModifyPro.do?pg=${pg}&board_num=${param.board_num}" style="width: 480px; "method="post" name="boardForm" enctype="multipart/form-data">
<input type="hidden" value="${pg}" name="pg">
<input type="hidden" value="${board_num}" name="board_num">
	<table>
		<tr>
			<td id="a">글쓴이</td>
			<td bgcolor="skyblue"><input type="text" name="board_name" required="required" value="${bean.board_name}"> </td>
		</tr>
		<tr>
			<td id="a">비밀번호</td>
			<td bgcolor="skyblue"><input type="password" name="board_pass" required="required" value="${bean.board_pass}"> </td>
		</tr>
		<tr>
			<td id="a">제목</td>
			<td bgcolor="skyblue"><input type="text" name="board_subject" required="required" value="${bean.board_subject}"> </td>
		</tr>
		<tr>
			<td id="a">내용</td>
			<td bgcolor="skyblue"><textarea rows="15" cols="45" name="board_content" required="required">${bean.board_content}</textarea> </td>
		</tr>
		<tr>
			<td id="a">파일첨부</td>
			<td bgcolor="skyblue">
			<input type="file" name="board_file">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="javascript:document.boardForm.submit()" onclick="">[수정]</a>
				<a href="javascript:history.back()">[뒤로]</a>
				<input type="submit" value="수정">
				<input type="button" value="뒤로" onclick="history.back()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>