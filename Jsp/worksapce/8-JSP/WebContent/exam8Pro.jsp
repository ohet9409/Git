<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String str_num1 = request.getParameter("num1");
    	String str_num2 = request.getParameter("num2");
    	String cal = request.getParameter("cal");
    	double num1=0;
    	double num2=0;
    	double result =0;
    	String errMsg="";
    	// 에러가 있는지 검사
    	if((!str_num1.equals("")) && (!str_num2.equals(""))) {
    		num1 = Double.parseDouble(str_num1);
    		num2 = Double.parseDouble(str_num2);
    		
    		switch(cal){
    		case "+": result = num1+num2; break;
    		case "-": result = num1-num2; break;
    		case "/": if(num2!=0) result = num1/num2; break;
    		case "*": result = num1*num2; break;
    		case "%": result = num1%num2; break;
    		}
    	} else {
    		errMsg = "입력값이 없습니다.";
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (errMsg.equals("")){ %>
	<%=num1 %> <%= cal %> <%=num2 %> = <%=result %>
<% }else {%>
	<%= errMsg %>
	<%} %>
	
	
</body>
</html>