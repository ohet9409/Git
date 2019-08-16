<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
h2 {text-align: center;}
table {
	margin: auto;
	width: 450px;
}
.th_left {width: 150px; background: orange;}
.td_right {width: 300px; background: skyblue;}
</style>
</head>
<body>
<h2>게시판 글등록</h2>
<form action="boardWritePro.do" method="post" name="boardForm"
	enctype="multipart/form-data">
	<table>
		<tr>
			<th class="th_left">글쓴이</th>
			<td class="td_right"><input type="text" name="board_name" required="required"></td>
		</tr>
		<tr>
			<th class="th_left">비밀번호</th>
			<td class="td_right"><input type="password" name="board_pass" required="required"></td>
		</tr>
		<tr>
			<th class="th_left">제목</th>
			<td bgcolor="skyblue"><input type="text" name="board_subject" required="required"></td>
		</tr>
		<tr>
			<th class="th_left">내용</th>
			<td class="td_right">
				<textarea rows="15" cols="40" name="board_content" required="required"></textarea>				
			</td>
		</tr>
		<tr>
			<th class="th_left">파일 첨부</th>
			<td class="td_right"><input type="file" name="board_file" required="required"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="등록">
				<input type="reset" value="다시쓰기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>









