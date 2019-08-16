<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% // 쿠키 데이터 확인
    	Cookie[] cookies = request.getCookies(); 	// 배열로 쿠키정보를 꺼낸다.
    	String cookieName ="id";
    	String result = "";
    	if(cookies != null){
    		for(int i=0; i<cookies.length; i++){
    			if(cookies[i].getName().equals(cookieName)){
    				result = cookies[i].getValue();
    				out.println("<p>쿠키의 이름: " + cookieName+"</p>");
    				out.println("<p>쿠키의 값: " + result+"</p>");
    			}
    		}
    	}
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>