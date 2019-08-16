<%@page import="member.dao.MemberDAO"%>
<%@page import="org.apache.catalina.tribes.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload= function() {
		if(${su > 0}) { 
				alert("회원탈퇴 성공");			
		 } else {
				alert("회원탈퇴 실패");
		}
		location.href = "index.jsp";
	}
</script>
</head>
<body>
<%-- <c:if test="${su>0 }">
<p>회원탈퇴 성공</p>
</c:if>
<c:if test="${su<=0 }">
<p>회원탈퇴 실패</p> 
</c:if>--%>
</body>
</html>




