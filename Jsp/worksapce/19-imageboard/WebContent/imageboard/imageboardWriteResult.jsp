<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${requestScope.su>0}">
	${requestScope.imageName} 상품이 등록 완료
</c:if>
<c:if test="${requestScope.su<=0}">
	저장실패
</c:if>
</body>
</html>