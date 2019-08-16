<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	String fileName = URLEncoder.encode(request.getParameter("fileName"),"utf-8");
		System.out.println("fileName = "+fileName);
    	String realFolder = request.getServletContext().getRealPath("../storage");
    	System.out.println("realFolder = "+realFolder);
    	File file = new File(realFolder,fileName);
    	response.setHeader("Content-Disposition", "attachment; fileName="
				+new String(URLEncoder.encode(fileName, "utf-8").replaceAll("\\+"," ")));
	response.setHeader("Content-Length", String.valueOf(file.length()));
	out.clear();
	out = pageContext.pushBody();
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	byte[] b = new byte[(int)file.length()];
	bis.read(b,0,b.length);
	bos.write(b);
	bis.close();
	bos.close();
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