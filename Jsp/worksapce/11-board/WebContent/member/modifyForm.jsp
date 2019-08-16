<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
    	request.setCharacterEncoding("utf-8");
    	String id  = (String)session.getAttribute("memId");
    	MemberDAO memberDAO = new MemberDAO();
    	MemberDTO memberDTO = memberDAO.selectOne(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js?v=1">/* 에러를 방지하기위해 ?뒤에 버전을 적어준다. */
</script>
</head>
<body>
<form action="modify.jsp" method="post" name="frm">
	<table border="1">
		<tr>
			<td align="center">
				<label>이름</label>
			</td>
			<td>
				<input type="text" name="name" value="<%=memberDTO.getName()%>"></td>
		</tr>
		<tr>
			<td align="center">
				<label>아이디</label>
			</td>
			<td>
				<%= id %>
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>비밀번호</label>
			</td>
			<td>
				<input type="password" name="pwd" size=30 value="<%=memberDTO.getPwd()%>">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>재확인</label>
			</td>
			<td>
				<input type="password" name="pwdCheck" size=30  value="<%=memberDTO.getPwd()%>">
				<input type= "button" value="확인" onclick="checkpwd()">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>성별</label>
			</td>
			<td>
			<% if(memberDTO.getGender().equals("m")) {%>
				<input type="radio" name="gender" value="m" checked>남
				<input type="radio" name="gender" value="f">여
				<%} else { %>
				<input type="radio" name="gender" value="m" >남
				<input type="radio" name="gender" value="f" checked>여
				<%} %>
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>이메일</label>
			</td>
			<td>
				<input type="text" name="email1" value="<%=memberDTO.getEmail1()%>">@
				<input type="text" name="email2" value="<%=memberDTO.getEmail2()%>">
			</td>
		</tr>
		<tr>
			<td align="center">
				<label>핸드폰</label>
			</td>
			<td>
				<input type="text" name="tel1"  value="<%=memberDTO.getTel1()%>">
				-
				<input type="text" name="tel2" value="<%=memberDTO.getTel2()%>">-
				<input type="text" name="tel3" value="<%=memberDTO.getTel3()%>">
			</td>
		</tr>
		<tr >
			<td align="center">
				<label >주소</label>
			</td>
			<td>
				<input type="text" name="addr" size="58" value="<%=memberDTO.getAddr()%>">
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="button" value="회원정보수정" onclick="checkModify()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<a href="../main/index.jsp">메인화면</a>
</body>
</html>