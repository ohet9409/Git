<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
    	// 데이터 처리
    	// post 방식에서의 한글 처리
    	request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	String gender = request.getParameter("gender");
    	String email1 = request.getParameter("email1");
    	String email2 = request.getParameter("email2");
    	String tel1 = request.getParameter("tel1");
    	String tel2 = request.getParameter("tel2");
    	String tel3 = request.getParameter("tel3");
    	String addr = request.getParameter("addr");
    	
    	// DB 처리
    	MemberDTO memberDTO = new MemberDTO();
    	memberDTO.setName(name);
    	memberDTO.setId(id);
    	memberDTO.setPwd(pwd);
    	memberDTO.setGender(gender);
    	memberDTO.setEmail1(email1);
    	memberDTO.setEmail2(email2);
    	memberDTO.setTel1(tel1);
    	memberDTO.setTel2(tel2);
    	memberDTO.setTel3(tel3);
    	memberDTO.setAddr(addr);
    	
    	MemberDAO memberDAO = new MemberDAO();
    	int su = memberDAO.write(memberDTO);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload= function() {
		<% if(su>0) {%>
		alert("회원 가입 성공");
		/* <location href = "../main.index.jsp";> */
		location.href="../main/index.jsp";
		<%} else {%>
		alert("회원 가입 실패");
		/* <location href = "../main.index.jsp";> */
		location.href="../writeForm.jsp";
		<%} %>
	}
		
</script>
</head>
<body>
	<% if(su>0) {%>
			<p>회원 가입 성공</p>
	<%} else {%>
			<p>회원 가입 실패</p>
	<%} %>
	<%-- <p>이름 : <%=name %></p>
	<p>아이디 : <%=id %></p>
	<p>비밀번호 : <%=pwd %></p>
	<p>성별 : <%=gender %></p>
	<p>이메일 : <%=email1 %>@<%=email2 %></p>
	<p>핸드폰 : <%=tel1 %>-<%=tel2 %>-<%=tel3 %></p>
	<p>주소: <%=addr %></p> --%>
</body>
</html>