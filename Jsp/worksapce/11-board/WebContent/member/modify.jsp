<%@page import="java.util.Set"%>
<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     	request.setCharacterEncoding("utf-8");
    	String id= (String)session.getAttribute("memId");
    	String name = request.getParameter("name");
    	String pwd = request.getParameter("pwd");
    	String addr = request.getParameter("addr");
    	String email1 = request.getParameter("email1");
    	String email2 = request.getParameter("email2");
    	String tel1 = request.getParameter("tel1");
    	String tel2= request.getParameter("tel2");
    	String tel3= request.getParameter("tel3");
    	String gender = request.getParameter("gender");
    	
    	MemberDTO memberDTO = new MemberDTO();
    	memberDTO.setId(id);
    	memberDTO.setName(name);
    	memberDTO.setPwd(pwd);
    	memberDTO.setEmail1(email1);
    	memberDTO.setEmail2(email2);
    	memberDTO.setTel1(tel1);
    	memberDTO.setTel2(tel2);
    	memberDTO.setTel3(tel3);
    	memberDTO.setGender(gender);
    	memberDTO.setAddr(addr);
    	
    	MemberDAO dao = new MemberDAO();
    	int su = dao.modify(memberDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		<%if(su>0) {%>
		alert("회원 정보 수정 성공");
		location.href = "../main/index.jsp";
		<%} else { %>
		alert("회원 정보 수정 실패");
		location.href = "modifyForm.jsp";
		<%} %>
	}
</script>
</head>
<body>
	
	
	<!-- <a href="../main/index.jsp">메인화면으로</a> -->
	<input type="button" onclick="location.href='../main/index.jsp'" value="메인화면으로">
</body>
</html>