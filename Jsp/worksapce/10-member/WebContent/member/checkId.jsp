<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	// 한글 깨짐 처리
    	request.setCharacterEncoding("utf-8");
    	// 데이터 처리
    	String id = request.getParameter("id");
    	// DB 처리
    	MemberDAO memberDAO = new MemberDAO();
    	boolean exist = memberDAO.isExistId(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkIdClose() {
	opener.frm.id.value="<%=id%>";	/* <!-- opener: 현재 브라우저를 기준으로 열려있는 브라우저 --> 현재 열려있는 브라우저에 id에 입력한 값을 저장한다.*/
	window.close();	/* 창을 닫는다 */
	opener.frm.pwd.focus(); /* 현재 열려있는 브라우저에 pwd로 포커스를 옮긴다. */
}
</script>
</head>
<body>
<form action="checkId.jsp" method="post"><!-- // 자기자신을 다시 호출 -->
	<%if(exist== false) {%>
	<p><%=id %>는 사용가능한 ID 입니다.</p>
	<p><input type="button" value="사용" onclick="checkIdClose()"></p>
	<%} else { %>
	<p><%=id %>는 이미 존재하는 ID 입니다. </p>
	<p>
		아이디 <input type="text" name="id">
		<input type="submit" value="중복체크">
	</p>
	<%} %>
</form>
</body>
</html>