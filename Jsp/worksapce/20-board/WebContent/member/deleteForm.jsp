<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		if(confirm("회원 탈퇴, 확실합니까?")) {
			location.href="delete.do";
		} else {
			alert("회원탈퇴 취소");
			location.href="index.jsp";
		}
	}
</script>
</head>
<body>

</body>
</html>