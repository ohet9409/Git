<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8");
	// Data 처리
	// 실제 폴더 위치
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.print("realFolder:" + realFolder);
	/* D:\android_3rd_oh\Dropbox\jsp\worksapce\.metadata\.plugins\org.eclipse.wst.server.core
	\tmp1\wtpwebapps\17-imageboard\storageD:\android_3rd_oh\Dropbox\jsp\worksapce
	\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\17-imageboard\storagerealFolder:
		D:\android_3rd_oh\Dropbox\jsp\worksapce\.metadata\.plugins
	\org.eclipse.wst.server.core\tmp1\wtpwebapps\17-imageboard\storage */
	
	// 업로드 : 파일 저장
 	MultipartRequest multi = new MultipartRequest(request, realFolder, 5 * 1024 * 1024, "utf-8",
			new DefaultFileRenamePolicy());
	
	// 데이터
	String imageId = multi.getParameter("imageId");
	String imageName = multi.getParameter("imageName");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
	String imageContent = multi.getParameter("imageContent");
	
	String image1 = multi.getOriginalFileName("image1");	//이미지 파일
	// DB
	ImageboardDTO dto = new ImageboardDTO();
	dto.setImageId(imageId);
	dto.setImageName(imageName);
	dto.setImagePrice(imagePrice);
	dto.setImageQty(imageQty);
	dto.setImageContent(imageContent);
	dto.setImage1(image1);
	
	ImageboardDAO dao = new ImageboardDAO();
	int su = dao.imageWrite(dto);
	// 데이터 공유
 	request.setAttribute("su", su);
	request.setAttribute("imageName", imageName);
	// 파일 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("../main/index.jsp?req=imageboardWriteResult");
	dispatcher.forward(request, response); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
<%-- <%if (su > 0) {%>
	alert("저장성공");
	
<%} else {%>
	alert("저장실패");
<%}%>
location.href="../main/index.jsp";  --%>
	
</script>
</head>
<body>

</body>
</html>