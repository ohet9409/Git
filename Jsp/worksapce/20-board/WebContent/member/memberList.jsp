<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#paging { color: blue; text-decoration: none;}
#currentPaging {color: red; text-decoration: underline;}
</style>
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
<c:forEach var="memberBean" items="${list}">
	<tr align="center">
		<td>${memberBean.getName()}</td>
		<td>${memberBean.getId()}</td>
		<td>${memberBean.getGender()}</td>
		<td>${memberBean.getEmail1()}@${memberBean.getEmail2()}</td>
		<td>${memberBean.getTel1()}-
			${memberBean.getTel2()}-
			${memberBean.getTel3()}
		</td>
		<td>${memberBean.getLogtime()}</td>
	</tr>
</c:forEach>
<%-- <% for(int i=0; i<list.size(); i++) { 
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
<% } %>	 --%>
	<!-- 페이징 -->
	<tr>
			<td colspan="6" align="center">
			<c:if test="${startPage>3 }">
				[<a href="memberList.do?pg=${startPage-1}" id="paging">이전</a>]
			</c:if>
		<c:forEach var="i" step="1" begin="${startPage}" end="${endPage}">
		<c:if test="${i==pg}">
			[<a href="memberList.do?pg=${i}" id="currentPaging"> ${i}</a>]
			</c:if>
		<c:if test="${i!=pg}">
			[<a href="memberList.do?pg=${i}" id="paging"> ${i}</a>]
		</c:if>
		</c:forEach>	
		<c:if test="${endPage<totalP}">	
				[<a href="memberList.do?pg=${endPage+1}" id="paging">다음</a>]
			</c:if>
			</td>
		</tr>
	<%-- <tr>
		<td colspan="6" align="center">
		<% if(startPage > 3) { %>
			[<a id="paging" href="memberList.jsp?pg=<%=startPage-1%>">이전</a>]
		<% } %>
			
		<% for(int i=startPage; i<=endPage ; i++) { %>
			<% if(pg == i) {	// 현재페이지 %>
			[<a id="currentPaging" href="memberList.jsp?pg=<%=i%>"><%=i%></a>]
			<% } else { %>
			[<a id="paging" href="memberList.jsp?pg=<%=i%>"><%=i%></a>]
			<% } %>
		<% } %>
	
		<% if(endPage < totalP) { %>			
			[<a id="paging" href="memberList.jsp?pg=<%=endPage+1%>">다음</a>]
		<% } %>
		</td>
	</tr> --%>
</table>
</body>
</html>











