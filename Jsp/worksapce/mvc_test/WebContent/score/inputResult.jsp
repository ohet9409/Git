<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(${su>0}){
			alert("저장성공");
			location.href="index.jsp"
		} else {
			alert("저장실패");
			location.href="inputForm.do"
		}
	}
</script>
</head>
<body>
	<%-- <c:if test="${su>0 }">
		<p>저장성공</p>
	</c:if>
	<c:if test="${su<=0 }">
		<p>저장실패</p>
	</c:if> --%>
</body>
</html>