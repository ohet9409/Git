<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = (String)session.getAttribute("memId");
    	MemberDTO dto = new MemberDTO();
    	dto.setId(id);
    	
    	MemberDAO dao = new MemberDAO();
    	int su = dao.delete(id);
    	if(su>0){
    		// 세션 삭제
        	session.removeAttribute("memName");
        	session.removeAttribute("memId");
        	
        	session.invalidate();	// 무효화, 전부 삭제
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		<%if(su>0) {%>
		alert("회원 탈퇴 성공");
		location.href = "../main/index.jsp";
		<%} else { %>
		alert("회원 탈퇴 실패");
		location.href = "../main/index.jsp";
		<%} %>
	}
</script>
</head>
<body>

</body>
</html>