<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	String localNum = request.getParameter("localNum");
    	String location = "";
    	switch(localNum){
    	case "0": location = "경기도"; break;
    	case "1": location = "서울"; break;
    	case "2": location = "강원도"; break;
    	case "3": location = "충청도"; break;
    	case "4": location = "경상도"; break;
    	case "5": location = "전라도"; break;
    	case "6": location = "인천"; break;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	선택하신 지역은
	<%= location %>
	입니다.
</body>
</html>