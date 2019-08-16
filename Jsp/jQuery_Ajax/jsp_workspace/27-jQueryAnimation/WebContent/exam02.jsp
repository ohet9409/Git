<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#sh > input:eq(0)").click(function(){
			$("#sh > div").fadeIn(500);
		});
	});
	$(function(){
		$("#sh > input:eq(1)").click(function(){
			$("#sh > div").fadeOut(500);
		});
	});
	$(function(){
		$("#sh > input:eq(2)").click(function(){
			$("#sh > div").fadeToggle(500);
		});
	});
</script>
</head>
<body>
<h1>fadeIn / fadeOut</h1>
<div id="sh">
	<input type="button" value="보이기">
	<input type="button" value="숨기기">
	<input type="button" value="페이드 토글">
	<div>
		<img alt="이미지" src="img/2.jpg" width="300px", height="200px">
	</div>
	<p>테스트</p>
</div>
</body>
</html>















