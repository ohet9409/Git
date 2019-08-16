<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 h3{
	margin-top: 0;
}
body{
	margin: 0;
	padding: 0;
	margin: auto;
	width: 100%;
	height: 100%;
}
#header{
	border: solid 1px;
	height: 10%;
	width: 100%;
	text-align: center;	/* 글자 가운데 맞춤 */
}
#container{
	/* padding-top:0px;
	margin-top: 0px; */
	height: 500px;
	width: 100%
}
#nav{
	float: left;
	background-color: orange;
	height: 100%;	/* 부모기준으로 100% */
	width: 20%;
}
#section{
	/* text-align: center;  */
	height: 100%;
	width: 80%;
	
}
#footer{
	width:100%;
	height:10%;
	border: solid 1px;
	text-align: center;
}
</style>
</head>
<body>
	<div id="header">
		<h2>이미지게시판</h2>
	</div>
	<div id="container">
		<div id="nav">
			<h3><a href="/18-imageboard/main/index.jsp">메인 화면</a></h3>
			
			<% if(session.getAttribute("memId") == null) { // 로그 아웃 상태%>
			<a href="/18-imageboard/main/index.jsp?req=writeForm">회원가입</a><br> 
			<a href="/18-imageboard/main/index.jsp?req=loginForm">로그인</a><br> 
			<% } else { // 로그인 상태%>
			<a href="/18-imageboard/main/index.jsp?req=logout">로그아웃</a><br> 
			<a href="/18-imageboard/main/index.jsp?req=modifyForm">회원정보수정</a><br>
			<a href="/18-imageboard/main/index.jsp?req=boardWriteForm">글쓰기</a><br> 
			<a href="/18-imageboard/main/index.jsp?req=imageboardWriteForm">이미지등록</a><br>
			<a href="/18-imageboard/imageboard/imageboardList.jsp?pg=1">이미지 목록</a><br>
			<% } %>
			<a href="/18-imageboard/main/index.jsp?req=boardList&pg=1">목록</a><br>
		</div>
		<div id="section">
			<c:if test="${param.req==null }">
			<jsp:include page="body.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardWriteForm' }">
			<jsp:include page="../imageboard/imageboardWriteForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardWriteResult' }">
			<jsp:include page="../imageboard/imageboardWriteResult.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardListResult' }">
			<jsp:include page="../imageboard/imageboardListResult.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardViewResult' }">
			<jsp:include page="../imageboard/imageboardViewResult.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardDeleteResult' }">
			<jsp:include page="../imageboard/imageboardDeleteResult.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardModifyForm' }">
			<jsp:include page="../imageboard/imageboardModifyForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='imageboardModifyFormResult' }">
			<jsp:include page="../imageboard/imageboardModifyFormResult.jsp"/>
			</c:if>
			<c:if test="${param.req=='boardList' }">
			<jsp:include page="../board/boardList.jsp"/>
			</c:if>
			<c:if test="${param.req=='writeForm' }">
			<jsp:include page="../member/writeForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='loginForm' }">
			<jsp:include page="../member/loginForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='boardWriteForm' }">
			<jsp:include page="../board/boardWriteForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='boardModifyForm' }">
			<jsp:include page="../board/boardModifyForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='loginOk' }">
			<jsp:include page="../member/loginOk.jsp"/>
			</c:if>
			<c:if test="${param.req=='loginFail' }">
			<jsp:include page="../member/loginFail.jsp"/>
			</c:if>
			<c:if test="${param.req=='logout' }">
			<jsp:include page="../member/logout.jsp"/>
			</c:if>
			<c:if test="${param.req=='modifyForm' }">
			<jsp:include page="../member/modifyForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='deleteForm' }">
			<jsp:include page="../member/deleteForm.jsp"/>
			</c:if>
			<c:if test="${param.req=='memberList' }">
			<jsp:include page="../member/memberList.jsp"/>
			</c:if>
			<c:if test="${param.req=='boardView' }">
			<jsp:include page="../board/boardView.jsp"/>
			</c:if>
		</div>
	</div>
	<div id="footer">
	<p>Ezen IT Academy</p>
	</div>
</body>
</html>