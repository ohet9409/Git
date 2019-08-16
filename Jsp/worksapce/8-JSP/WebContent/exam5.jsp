<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름과 성적을 입력하세요</h1>
	<form action="exam5Pro.jsp" method="get">
		<label>이름:</label> <input type="text" name="name"><br> 
		<label>국어:</label>
		<input type="text" name="kor"><br> 
		<label>영어:</label> 
		<input type="text" name="eng"><br> 
		<label>수학:</label> <input type="text" name="mat"><br>
		 <input type="submit" value="입력완료"> 
		 <input type="reset" value="다시작성"><br>
	</form>
</body>
</html>