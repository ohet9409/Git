<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	// 데이터 처리가 주 역할
	Date  date = new Date();	// 현재 시각을 불러온다
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초"); // 현재 시각의 서식을 지정
	/* SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); */
	String strDate = dateFormat.format(date);	// 문자열로  현재시각을 서식에 맞춰서 저장
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>오늘 날짜는 <%=strDate %>입니다.</p>
</body>
</html>