<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	//데이터
    	String fileName = request.getParameter("fileName");
    	// 실제 폴더 위치 얻어오기
    	String realFolder = request.getServletContext().getRealPath("/storage");
    	// 다운받고자하는 파일 = 폴더이름 + 파일이름
    	File file = new File(realFolder,fileName);
    	System.out.println("file="+file);
    	// 서버에서 클라이언트로 파일을 보낼 때는, response header에 파일 정보를 함께 보내야 함.
    	response.setHeader("Content-Disposition", "attachment; fileName="
    					+new String(URLEncoder.encode(fileName, "utf-8").replaceAll("\\+"," ")));
   		response.setHeader("Content-Length", String.valueOf(file.length()));
   		// 파일 다운로드 : 서버에서 클라이언트로 파일 전송
   		// HDD에서 RAM으로 파일을 읽어오고, 그것을 클라이언트로 전송함 
   		out.clear();
   		out = pageContext.pushBody();	// 기존 jsp의 객체 out의 스트림을 지우고 출력을 해야 예외 발생이 안생김
   		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
   		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
   		
   		byte[] b = new byte[(int)file.length()];
   		bis.read(b,0,b.length);	// HDD에서 RAM으로 파일을 읽어오기
   		bos.write(b);			// 서버에서 클라이언트로 전송
   		
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