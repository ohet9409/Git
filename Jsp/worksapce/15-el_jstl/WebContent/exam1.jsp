<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr align="center">
		<td width="150">표현식</td>
		<td width="150">값</td>   
		<td width="150">JSP 표현식</td>       
	</tr>
	<tr align="center">
		<td width="150">\${25+36}</td>
		<td width="150">${25+36}</td>          
		<td><%=25+36 %></td>
	</tr>
	<tr align="center">
		<td width="150">\${25/6}</td>
		<td width="150">${25/6}</td>      
		<td><%=25/6 %></td>    
	</tr>
	<tr align="center">
		<td width="150">\${25%6}</td>
		<td width="150">${25%6}</td>   
		<td><%=25%6 %></td>       
	</tr>
	<tr align="center">
		<td width="150">\${25>36}</td>
		<td width="150">${25>36}</td>    
		<td><%=25>36 %></td>      
	</tr>
	<tr align="center">
		<td width="150">\${header['host']}</td>
		<td width="150">${header['host']}</td>  
		<td><%=request.getServerName() %>:<%=request.getServerPort() %> </td>
		      
	</tr>
	<tr align="center">
		<td width="150">\${header.host}</td>
		<td width="150">${header.host}</td> 
		<td><%=request.getServerName() %>:<%=request.getServerPort() %> </td>
		        
	</tr>
</table>
</body>
</html>