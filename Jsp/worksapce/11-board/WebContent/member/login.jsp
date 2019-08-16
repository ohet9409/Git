<%@page import="java.net.URLEncoder"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	
    	// DB 처리
    	MemberDTO memberDTO = new MemberDTO();
    	MemberDAO memberDAO = new MemberDAO();
    	String name = memberDAO.login(id, pwd);
    	// 일치하는 데이터가 있을 경우
    	if(name != null){ 
    		/* 페이지 이동
    			get 방식으로 이동하기 때문에 이름과 id가 주소창에 오픈된다. 보안에 취약
    			그래서 쿠키나 세션으로 보내야 함(다음 장에서 할 것임).
    		*/		//loginOK.jsp 에 name, id값 전달           한글깨짐방지하기 위해 encode
    		//response.sendRedirect("loginOK.jsp?name="+URLEncoder.encode(name,"utf-8")+"&id="+id);	//요청한 페이지로 이동
    		/* 데이터 공유 1: 쿠키 이용 */
    		/* Cookie cookie1 = new Cookie("memName",URLEncoder.encode(name,"utf-8"));
    		cookie1.setMaxAge(120);	//120초 설정
    		Cookie cookie2 = new Cookie("memId",id);
    		cookie1.setMaxAge(120);	//120초 설정
    		
    		response.addCookie(cookie1); // name값을 쿠키정보로 전달
    		response.addCookie(cookie2); // id값을 쿠키정보로 전달
    		
    		response.sendRedirect("loginOK.jsp");	// 페이지 이동 */
    		
    		/* 데이터 공유 2: 세션 이용 */
    		session.setAttribute("memName", name);
    		session.setAttribute("memId", id);
    		
    		response.sendRedirect("loginOK.jsp");	// 페이지 이동 */
    	// 일치하는 데이터가 없을 경우
    	} else {
    		response.sendRedirect("loginFail.jsp");	//요청한 페이지로 이동
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