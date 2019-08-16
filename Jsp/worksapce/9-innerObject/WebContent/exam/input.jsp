<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		if(document.frm.x.value == ""){
			alert("X값을 입력하세요");
			document.frm.x.focus();
		} else if(document.frm.y.value == ""){
			alert("Y값을 입력하세요");
			document.frm.y.focus();
		} else
			document.frm.submit();
	}
</script>
</head>
<body>
<form action="result2.jsp" method="post" name="frm">
	<table border="1">
		<tr align="center">
			<td width="50"><label>X</label> </td>
			<td><input type="text" name="x"></td>
		</tr>
		<tr align="center">
			<td><label>Y</label> </td>
			<td><input type="text" name="y"></td>
		</tr>
		<tr align="center">
			<td colspan="2"> 
			<input type="submit" value="계산">
			<input type="reset" value="원래대로">
			<input type="button" value="스크립트" onclick="check()">
			</td>
		</tr>
	</table>
</form>
</body>
</html>