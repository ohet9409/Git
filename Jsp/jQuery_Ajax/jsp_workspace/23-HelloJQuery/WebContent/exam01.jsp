<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
/* jQuery 사용법 2 */
 	$(function() {
 		var h1 = document.getElementById("hello");	// 아이디가 hello인 것을 찾는다  
		h1.innerHTML = "Hello jQuery";
	});
	/* jQuery 사용법 1
	function hello() {
		var h1 = document.getElementById("hello");	// 아이디가 hello인 것을 찾는다  
		h1.innerHTML = "Hello jQuery";
	}
	// javascript의 onload 이벤트와 같은 효과
	jQuery(hello); */
	/*
	 window.onload = function() {	// onload: 브라우저가 모든 태그를 인식한 다음 동작 
		hello();	 // hello 함수 호출 
	} */
</script>
</head>
<body>
<h1 id="hello">Hello</h1>
</body>
</html>