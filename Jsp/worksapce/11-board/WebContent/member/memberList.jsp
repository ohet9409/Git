
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	MemberDAO dao = new MemberDAO();
    	/* List<MemberDTO> list = dao.selectList(); */
    	// 데이터
    	int pg= Integer.parseInt(request.getParameter("pg"));
    	// DB처리
    	// 5개씩 목록보여주기
    	// pg=1 rn>=1 and rn<=5
    	// pg=2 rn>=6 and rn<=10
    	// pg=3 rn>=11 and rn<=15 
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	List<MemberDTO> list= dao.memberList(startNum, endNum);
    	/*	페이징 처리
    		총 회원수 : 12	(12+4)/5 = 3.xx=>3 
    		총 페이지수: 3
    		
    		총 회원수 : 21	(21+4)/5 = 5
    		총 페이지수: 5
    		
    		총 페이지수 = (총회원수+4)/5
    	*/
    	int totalB = dao.getTotalB(); // 총 회원수
    	int totalP = (totalB+4)/5; //(59/5) = 총 11페이지
    	/*	3블럭
    			[1][2][3][다음]
    		[이전][4][5][6][다음]
    		[이전][7][8]
    	*/
    	int startPage =(pg-1)/3*3+1;
    	int endPage=startPage+2; //마지막 페이지 보정 필요
    	if(totalP<endPage){
    		endPage = totalP;	//마지막 페이지 보정 작업
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#paging {
	color: blue;
	text-decoration: none;
}
#currentPaging{
	color: red;
	text-decoration: underline;
}
</style>
</head>
<body>
		<table>
		<tr style="background:  orange;">
		<th width="50">이름</th>
		<th width="70">아이디</th>
		<th width="50">성별</th>
		<th width="150">이메일</th>
		<th width="150">전화번호</th>
		<th width="150">가입일</th>
		</tr>
		<tr></tr>
		<%for(int i=0; i<list.size();i++ ){ %>
		<%MemberDTO dto = list.get(i); %>
    		<tr align="center">
    			<td><%=dto.getName() %></td>
    			<td><%=dto.getId() %></td>
    			<td><%=dto.getGender() %></td>
    			<td><%=dto.getEmail1() %>@<%=dto.getEmail2() %></td>
    			<td><%=dto.getTel1() %>-<%=dto.getTel2() %>-<%=dto.getTel3() %></td>
    			<td><%=dto.getLogtime() %></td>
    		</tr>
    	<% }%>
    	<!-- 페이징 -->
    	<tr>
    		<td colspan="6" align="center">
    			<%if(startPage>3){ %>
				[<a id="paging" href="memberList.jsp?pg=<%=startPage-1%>">이전</a>]
				<%} %>
				<% for(int i=startPage; i<=endPage; i++){ %>
				<%if(pg==i) {%> <!-- 현재 페이지 -->
					[<a id="currentPaging" href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
					<%}else{ %>
					[<a id="paging" href="memberList.jsp?pg=<%=i%>"><%=i %></a>]
					<%} %>
				<%} %>
				<%if(endPage < totalP){ %>
				[<a id="paging" href="memberList.jsp?pg=<%=endPage+1%>">다음</a>]
				<%} %>
			</td>
    	</tr>
    	</table>
</body>
</html>