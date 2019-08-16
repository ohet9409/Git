<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    	request.setCharacterEncoding("utf-8");
    	ScoreDAO dao = new ScoreDAO();
    	
    	int pg= Integer.parseInt(request.getParameter("pg")); 
    	int endNum = pg*10;
    	int startNum = endNum-9;
    	List<ScoreDTO> list = dao.scoreList(startNum, endNum);
    	
    	int count = dao.totalA();	// 총 글수
    	int totalP = (count+4)/10;
    	int startPage = (pg-1)/3*3 + 1;	
    	int endPage = startPage + 2;
    	if(totalP < endPage) {
    		endPage = totalP;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div {
	margin: auto;
	width: 800px;
}
table {
	width: 100%;
}
</style>
</head>
<body>
<h2 align="center">성적 리스트</h2>
<div>
	<table border="1">
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>국어점수</th>
			<th>영어점수</th>
			<th>수학점수</th>
			<th>총점</th>
			<th>평균</th>
		</tr>
		<%for(ScoreDTO dto : list) {%>
		<tr>
			<td><%=dto.getHakbun() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getKor() %></td>
			<td><%=dto.getEng() %></td>
			<td><%=dto.getMat() %></td>
			<td><%=dto.getTotal() %></td>
			<td><%=dto.getAvg() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="7" align="center">
			<%if(startPage > 3) {%>
			[<a href="scoreList.jsp?pg=<%=startPage-1%>">이전</a>]
			<%} %>
			<%for(int i=startPage; i<=endPage; i++){ %>
				<% if(pg==i){%>
				[<a href="scoreList.jsp?pg=<%=i %>"> <%=i %></a>]
			<%} else { %>
				[<a href="scoreList.jsp?pg=<%=i %>"> <%=i %></a>]
			<%} }%>
			<%if(endPage<totalP){ %>
			[<a href="scoreList.jsp?pg=<%=endPage+1%>">다음</a>]
			<%}%>
			</td>
		</tr>
	</table>
	<a href="../main/index.jsp">메인으로</a>
	</div>
</body>
</html>