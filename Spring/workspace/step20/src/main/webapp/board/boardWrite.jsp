<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	if(${su>0}){
		alert("저장성공")
		location.href="boardList.do";
	}else{
		alert("저장실패")
		history.back();
	}
	</script>
</head>
<body>

</body>
</html>