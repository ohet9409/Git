<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("utf-8");
    int x = Integer.parseInt(request.getParameter("x"));
    int y = Integer.parseInt(request.getParameter("y"));  
    double result= (double)x / (double)y ;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=x %> + <%=y %> = <%=x+y %></p>
<p><%=x %> - <%=y %> = <%=x-y %></p>
<p><%=x %> * <%=y %> = <%=x*y %></p>
<p><%=x %> / <%=y %> = <%=result %></p>
</body>
</html>