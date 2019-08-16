<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	/* int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));*/
	
	String strX = request.getParameter("x");
	String strY = request.getParameter("y");
	int x =0;
	int y = 0;
	// 입력값이 있는 지 검사
	/* if(!strX.equals("") && !strY.equals("")){
		x = Integer.parseInt(strX);
		y = Integer.parseInt(strY);
	} */
	if(!strX.isEmpty() && !strY.isEmpty()){
		x = Integer.parseInt(strX);
		y = Integer.parseInt(strY);
	}
	// 입력값이 숫자만으로 구성되었는 지 검사
	// => 정규표현식으로 검사
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%=x%>
		+
		<%=y%>
		=
		<%=x + y%></p>
	<p><%=x%>
		-
		<%=y%>
		=
		<%=x - y%></p>
	<p><%=x%>
		*
		<%=y%>
		=
		<%=x * y%></p>
	<p><%=x%>
		/
		<%=y%>
		=
		<%=(double)x/y %></p>
	<br>
	클라이언트ID = <%=request.getRemoteAddr() %><br>
	요청정보 길이 = <%=request.getContentLength() %><br>
	요청정보 인코딩 = <%=request.getCharacterEncoding() %><br>
	요청정보 컨텐트타입 = <%=request.getContentType() %><br>
	요청정보 프로토콜 = <%=request.getProtocol() %><br>
	요청정보 전송방식 = <%=request.getMethod() %><br>
	요청 URI = <%=request.getRequestURI() %><br>
	요청 URL = <%=request.getRequestURL() %><br>
	컨텍스트 경로 = <%=request.getContextPath() %><br>
	서버이름 = <%=request.getServerName() %><br>
	서버포트 = <%=request.getServerPort() %><br>	
	<hr>
	<h3>헤더정보</h3>
	<%
		Enumeration header = request.getHeaderNames();
		while(header.hasMoreElements()){
			String headerName = (String) header.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
		<%=headerName %> : <%=headerValue %> <br>
	<%
	}
	%>
</body>
</html>