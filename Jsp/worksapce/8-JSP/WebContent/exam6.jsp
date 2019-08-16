<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>이름과 전화번호를 입력하세요</h1>
<form action="exam6Pro.jsp" method="get">
	<label>이름: </label>
	<input type="text" name="name"><br>
	<label>전화번호: </label>
	<select name=local>
		<option value="서울">서울 </option>
		<option value="경기">경기</option>
		<option value="강원">강원 </option>
	</select>
	- <input type="text" name="tel"><br>
	<input type="submit" value="제출">
	<input type="reset" value="다시작성">
</form>
</body>
</html>