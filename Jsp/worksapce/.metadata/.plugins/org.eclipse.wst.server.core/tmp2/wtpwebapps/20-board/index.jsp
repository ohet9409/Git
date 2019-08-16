<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
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
section{
	width: auto;
	height: 100%;
	
}
footer{
	width: 100%;
	height: 10%;
	text-align: center;
	border: 1px solid lightgray;
}
</style>
</head>
<body>
<header>
	<h1 align="center">게시판</h1>
</header>
<div id="container">
	<nav>
	<h2 align="center"><a href="index.jsp"> * 메인 화면 *</a></h2>
	<c:if test="${memId != null}"> <!-- // 로그인 상태 -->
	<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${memId}님 환영합니다</b>
	</c:if>
		<ul>
		<c:if test="${memId == null}"> <!-- // 로그 아웃 상태 -->
			<li><a href="loginForm.do">로그인</a></li>
			<li><a href="writeForm.do">회원가입</a></li>
		</c:if>
		<c:if test="${memId != null}"> <!-- // 로그인 상태 -->
		<li><a href="memberList.do">회원목록</a></li>
			<li><a href="modifyForm.do">회원정보수정</a></li>
			<li><a href="deleteForm.do">회원탈퇴</a></li>
			<li><a href="logout.do">로그아웃</a></li>
			<li><a href="boardWriteForm.do">게시판 글쓰기</a></li>
		</c:if>
		<li><a href="boardList.do">게시판 목록</a></li>
		</ul>
	</nav>
	<section>	
		<c:if test="${req_page == null }">
			<img alt="이미지" src="image/lion.jpg">
		</c:if>
		<c:if test="${req_page != null}">
			<jsp:include page="${req_page}"/>
		</c:if>
		
	
	</section>
</div>
<footer>
	<p>Ezen IT Academy</p>
</footer>
</body>
</html>