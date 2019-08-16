<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${su > 0}){
		alert("${imageName} 수정성공");
	} else {
		alert("${imageName} 수정실패");
	}
	location.href="imageboardList.jsp?pg=${pg}";
</script>
</head>
<body>
	<c:if test="${su!= 0}">
		<b>${imageName}</b> 수정성공
	</c:if>
	<c:if test="${su== 0}">
		<b>${imageName}</b> 수정실패
	</c:if>
	<br><input type="button" value="이전목록으로" onclick="location.href='imageboardList.jsp?pg=${pg}'">
</body>
</html>
