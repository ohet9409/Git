<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>***변수 설정***</h3>
	<c:set var="name">홍길동</c:set>
	<c:set var="age" value="25"/>
	나의 이름은 <c:out value="${name}"/>입니다.<br>
	내 나이는 ${age}살 입니다.<br>
	나의 키는 ${height}입니다.
	<hr>
	<h3>***변수 삭제***</h3>
	<c:remove var="name"/>
	나의 이름은 <c:out value="${name}"/>입니다.<br>
	내 나이는 ${age}살 입니다.<br>
	나의 키는 ${height}입니다.
	<hr>
	<h3>** forEach (일반 for문 대체) **</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i} &nbsp;&nbsp;
		<c:set var="sum" value="${sum+i}"/>
	</c:forEach>
	<br>
	1~10까지의 합  = ${sum}<br>
	<h3>** forEach (확장 for문 대체) **</h3>
	<c:set var="ar" value="10,20,30,40,50"/> <!-- 배열 만들기 -->
	<c:forEach var="data" items="${ar}">
		${data} &nbsp;&nbsp;
	</c:forEach>
	<%-- java for와 비교
		<%for(int data: ar) {%>
			<%=data + " "%>
		<%}%>
	 --%> 
	 <hr>
	 <h3>** 문자열 분리 **</h3>
	 <c:set var="cars" value="소나타,그랜저,아우디,링컨,페라리"/> <!-- 배열 만들기 -->
	 <c:forTokens var="car" items="${cars}" delims=","><!--콤마(,)기준으로 문자열 분리  -->
	 	${car}<br>
	 </c:forTokens>
	 <hr>
	 <h3>** if **</h3>
	 <c:set var="age" value="15"/>
	 <c:if test="${age >= 19}">
	 	성인
	 </c:if>
	 <c:if test="${age < 19}">
	 	청소년
	 </c:if>
	 <hr>
	 <h3>** switch **</h3>
	 <c:set var="color" value="sky"/>
	 	<c:choose>
	 		<c:when test="${color == 'red'}">빨강</c:when>
	 		<c:when test="${color == 'green'}">녹색</c:when>
	 		<c:when test="${color == 'blue'}">파랑</c:when>
	 		<c:when test="${color == 'magenta'}">보라</c:when>
	 		<c:otherwise>하늘</c:otherwise>
	 	</c:choose>
	 
</body>
</html>