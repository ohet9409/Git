<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 600px; border-collapse: collapse;">
		<tr>
			<td colspan="3">${dto.getSubject()}</td>
		</tr>
		<tr align="center">
			<td>글번호: ${dto.getSeq()}</td>
			<td>작성자: ${dto.getName()} </td>
			<td>조회수: ${dto.getHit()}</td>
		</tr>
		<tr style="height: 300px;">
			<td colspan="3" valign="top">${dto.getContent()}</td>
		</tr>	
		<tr>
			<td colspan="3">
				<input type="button" value="목록" onclick="location.href='../board/boardList.do?pg='+${pg}"> 
				<c:if test="${memId == dto.id}">
				
				<input type="button" value="글수정" onclick="location.href='../board/boardWriteForm.jsp?seq='+${dto.getSeq()}+'&pg='+${pg}">
				<input type="button" value="글삭제" onclick="location.href='../board/boardDelete.do?seq='+${dto.getSeq()}+'&pg='+${pg}">
		
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>