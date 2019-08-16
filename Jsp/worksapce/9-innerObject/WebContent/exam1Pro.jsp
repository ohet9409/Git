<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	// 데이터 처리
	// post 방식에서의 한글처리
	request.setCharacterEncoding("utf-8");
	
    String hakbun = request.getParameter("hakbun");
    String name = request.getParameter("name");
    String grade = request.getParameter("grade");
    String sub = request.getParameter("sub");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생 정보</h2>
<table border="1">
	<tr align="center">
		<td width="150px">학번</td>
		<td width="150px"><%=hakbun %></td>
	</tr>
	<tr align="center">
		<td>이름</td>
		<td><%=name %></td>
	</tr>
	<tr align="center">
		<td>학년</td>
		<td><%=grade %></td>
	</tr>
	<tr align="center">
		<td>선택과목</td>
		<td><%=sub %></td>
	</tr>
</table>

</body>
</html>