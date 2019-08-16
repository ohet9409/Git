<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	margin: 0;
	padding: 0;
	width: 100%;
	height: 600px;
}
header{
	text-align: center;
	height: 10%;
	width: 100%;
	border: solid 1px;
}
nav{
	float: left;
	height: 100%;
	width: 20%;
	background-color: skyblue;
}
section{
	height: 100%;
	width: 80%;
}
footer{
	text-align: center;
	clear: both;
	border: solid 1px;
	width: 100%;
	height: 5%;
	padding-top: 2%;
}
</style>
</head>
<body>
<header><h2>도서관리 </h2></header>
<nav>
	<a href="../main/index.jsp">메인화면</a><br>
	<a href="../main/index.jsp?req=bookForm">도서입력</a><br>
	<a href="../main/index.jsp?req=bookList&pg=1">도서목록</a>
</nav>
<section>
	<c:if test="${param.req==null }">
	<jsp:include page="body.jsp"/>
	</c:if>
	<c:if test="${param.req=='bookForm' }">
	<jsp:include page="../book/bookForm.jsp"/>
	</c:if>
	<c:if test="${param.req=='bookList' }">
	<jsp:include page="../book/bookList.jsp"/>
	</c:if>
	<c:if test="${param.req=='bookListResult' }">
	<jsp:include page="../book/bookListResult.jsp"/>
	</c:if>
	<c:if test="${param.req=='bookResult' }">
	<jsp:include page="../book/bookResult.jsp"/>
	</c:if>
</section>
<footer>제작자</footer>
</body>
</html>