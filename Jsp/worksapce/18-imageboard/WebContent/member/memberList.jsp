<%@page import="java.util.List"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// DB 처리
	MemberDAO memberDAO = new MemberDAO();
	List<MemberDTO> list = memberDAO.selectList();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr style="background: orange;">
		<th width="50">이름</th>
		<th width="100">아이디</th>
		<th width="50">성별</th>
		<th width="150">이메일</th>
		<th width="150">전화번호</th>
		<th width="150">가입일</th>
	</tr>
<% for(int i=0; i<list.size(); i++) { 
	MemberDTO memberDTO = list.get(i);
%>	
	<tr align="center">
		<td><%=memberDTO.getName()%></td>
		<td><%=memberDTO.getId()%></td>
		<td><%=memberDTO.getGender()%></td>
		<td><%=memberDTO.getEmail1()%>@<%=memberDTO.getEmail2()%></td>
		<td><%=memberDTO.getTel1()%>-
			<%=memberDTO.getTel2()%>-
			<%=memberDTO.getTel3()%>
		</td>
		<td><%=memberDTO.getLogtime()%></td>
	</tr>
<% } %>	
</table>
</body>
</html>



