<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	margin: auto;
	padding:0;
	height: 100%;
	width: 800px;
}
header{
	width: 100%;
	height: 10%;
	background: yellow;
	border: 1px solid lightgray;
}
#container{
	width: 100%;
	height: 600px;
	border: 1px solid lightgray;
	padding: 0;
	
}
nav{
	float: left;
	width: 25%;
	height: 100%;
	border: solid 1px;
	background-color: yellow;
	text-align: left;
}
ul{
	padding-left: 20px;
}
li{
	padding-bottom: 20px;
}
section{
	float: left;
	width: auto;
	height: 100%;
	
}
footer{
	clear: both;
	width: 100%;
	height: 10%;
	text-align: center;
	border: 1px solid lightgray;
}
</style>
</head>
<body>
<header>
	<h1 align="center">성적입력 게시판</h1>
</header>
<div id = "container"> 
<nav>
<h2 align="center"><a href="index.jsp"> 메인화면</a></h2>
<ul>
	<li><a href="inputForm.do">성적입력</a></li>
	<li><a href="listForm.do">성적목록</a></li>
</ul>
</nav>
<section>
	<c:if test="${req_page == null }">
		<img alt="이미지" src="image/lion.jpg">
	</c:if>
	<c:if test="${req_page != null }">
		<jsp:include page="${req_page }"/>
	</c:if>
</section>
</div>
<footer>제작자표시</footer>
</body>
</html>