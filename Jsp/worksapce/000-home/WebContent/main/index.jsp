<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"></link>
<script type="text/javascript"></script>
</head>
<body>
	<form action="" class = "wrap" method="post">
	<header>
	<table border="1" style="border-collapse: collapse; width: 800px">
		<tr class ="menu">
			<td align="center">자유 게시판</td>
			<td align="center">영화 리뷰</td>
			<td align="center">도서 리뷰</td>
			<td align="center">드라마 리뷰</td>
			<td align="center">만화 리뷰</td>
		</tr>
	</table>
	</header>
	<nav>
		<label>아이디</label><br>
		<input type="text" placeholder="아이디 입력" id="id" style="width: 120px;"name="id"><br>
		<label>비밀번호</label><br>
		<input type="text" placeholder="비밀번호 입력" id="pwd" style="width: 120px;" name="pwd">	<br>
		<input type="button" value="로그인" onclick="location.href='../member/login.jsp'">
		<input type="button" value="회원가입" onclick="location.href='../member/writeForm.jsp'">
	</nav>
	</form>
</body>
</html>