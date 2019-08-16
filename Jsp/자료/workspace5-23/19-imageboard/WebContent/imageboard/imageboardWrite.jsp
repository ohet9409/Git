<%@page import="imageboard.dao.ImageboardDAO"%>
<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// Data 처리
	// 실제 폴더 위치
	String realFolder = request.getServletContext().getRealPath("/storage");
	// realFolder = D:\android_3rd\jsp\workspace\.metadata\.plugins
	//				  \org.eclipse.wst.server.core
	//				  \tmp0\wtpwebapps\17-imageboard\storage
	System.out.println("realFolder = " + realFolder);
	// 업로드 : 파일 저장
	MultipartRequest multi = new MultipartRequest(request, realFolder,
			5*1024*1024, "UTF-8");
	// 데이터 
	String imageId = multi.getParameter("imageId");
	String imageName = multi.getParameter("imageName");
	int imagePrice = Integer.parseInt(multi.getParameter("imagePrice"));
	int imageQty = Integer.parseInt(multi.getParameter("imageQty"));
	String imageContent = multi.getParameter("imageContent");
	String image1 = multi.getOriginalFileName("image1");
	// DB
	ImageboardDTO imageboardDTO = new ImageboardDTO();
	imageboardDTO.setImageId(imageId);
	imageboardDTO.setImageName(imageName);
	imageboardDTO.setImagePrice(imagePrice);
	imageboardDTO.setImageQty(imageQty);
	imageboardDTO.setImageContent(imageContent);
	imageboardDTO.setImage1(image1);

	ImageboardDAO imageboardDAO = new ImageboardDAO();
	int su = imageboardDAO.imageboardWrite(imageboardDTO);
	// 데이터 공유
	request.setAttribute("su", su);
	request.setAttribute("imageName", imageName);
	// 파일 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=imageboardWriteResult");
	dispatcher.forward(request, response);
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