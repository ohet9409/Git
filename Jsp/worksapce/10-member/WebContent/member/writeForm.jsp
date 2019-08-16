<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js?v=1">/* 에러를 방지하기위해 ?뒤에 버전을 적어준다. */
</script>
</head>
<body>
<form action="write.jsp" method="post" name="frm">
	<table border="1">
		<tr>
			<td align="center">
				<label>이름</label>
			</td>
			<td>
				<input type="text" name="name" placeholder="이름 입력">
				
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>아이디</label>
			</td>
			<td>
				<input type="text" name="id">
				<input type="button" value="중복체크" onclick="checkId()">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>비밀번호</label>
			</td>
			<td>
				<input type="password" name="pwd" size=30>
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>재확인</label>
			</td>
			<td>
				<input type="password" name="pwdCheck" size=30>
				<input type= "button" value="확인" onclick="checkpwd()">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>성별</label>
			</td>
			<td>
				<input type="radio" name="gender" value="m">남
				<input type="radio" name="gender" value="f">여
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>이메일</label>
			</td>
			<td>
				<input type="text" name="email1">@
				<select name="email2">
					<option value="naver.com">naver.com</option>
					<option value="daum.com">daum.com</option>
					<option value="gmail.com">gmail.com</option>
					<option value="nate.com">nate.com</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>핸드폰</label>
			</td>
			<td>
				<select name="tel1" style="width: 60px; ">
					<option value="010">010</option>
					<option value="011">011</option>
				</select> -
				<input type="text" name="tel2">-
				<input type="text" name="tel3">
			</td>
		</tr>
		<tr >
			<td align="center">
				<label >주소</label>
			</td>
			<td>
				<input type="text" name="addr" size="58">
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="button" value="회원가입" onclick="checkInput()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>