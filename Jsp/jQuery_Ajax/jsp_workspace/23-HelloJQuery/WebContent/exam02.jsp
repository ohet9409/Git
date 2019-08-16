<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		var a = $("#hello");	//	아이디가 hello인것을 찾아서 a객체에 저장
		a.html("Hello jQuery");
		// =>
		$("#hello").html("안녕 제이쿼리");	// 아이디가 hello인것을 찾아서 글씨를 해당 태그에 출력한다. 
	});
</script>
</head>
<body>
<h1 id="hello"></h1>
</body>
</html>