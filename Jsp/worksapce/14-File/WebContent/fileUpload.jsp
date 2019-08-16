<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터처리 : 문자열 + 파일
	// 실제 저장 폴더 위치 찾기
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println("realFolder="+realFolder);
	// 파일 저장 : 5*1024*1024: 5MB /new DefaultFileRenamePolicy(): 이름을 새롭게 해서 저장(중복저장가능), 안쓰면 덮어쓰기 적용
	MultipartRequest multi = new MultipartRequest(request, realFolder,5*1024*1024,"utf-8", new DefaultFileRenamePolicy());
	String subject = multi.getParameter("subject");
	String content = multi.getParameter("content");
	// 클라이언트에서 넘어온 파일 이름
	String originalFileName1 = multi.getOriginalFileName("upload1");
	String originalFileName2 = multi.getOriginalFileName("upload2");
	// 서버에 저장되는 파일 이름
	String fileName1 = multi.getFilesystemName("upload1");
	String fileName2 = multi.getFilesystemName("upload2");
	// 파일 크기
	File file1 = multi.getFile("upload1");
	File file2 = multi.getFile("upload2");
	System.out.println("file1="+file1);
	
	long fileSize1=0;
	long fileSize2=0;
	
	if(file1 !=null){
		fileSize1 = file1.length();
	}
	if(file2 !=null){
		fileSize2 = file2.length();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<li>제목 = <%=subject %></li>-
	<li>내용 = <%=content %></li>
	<li>파일 = (원래)<%=originalFileName1 %> &nbsp;&nbsp;&nbsp;&nbsp;
			 (저장된)<a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(fileName1, "utf-8")%>"><%=fileName1 %></a></li>
			 												<!-- URLEncoder.encode(fileName1, "utf-8"): 한글 설정 -->
	<li>크기 = <%=fileSize1 %></li><br><br>
	<li>파일 = (원래)<%=originalFileName2 %> &nbsp;&nbsp;&nbsp;&nbsp;
			 (저장된)<%=fileName2 %></li>
	<li>크기 = <%=fileSize2 %></li><br><br>
</ul>
</body>
</html>