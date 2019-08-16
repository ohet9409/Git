<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form{
	margin-left: 160px;

	
}
</style>
<script type="text/javascript">
	function check() {
		if(document.frm.hakbun.value == ""){
			alert("학번을 입력하세요");
			document.frm.hakbun.focus();
		}
		else if(document.frm.name.value == ""){
			alert("이름을 입력하세요");
			document.frm.name.focus();
		} else{
			if(confirm("제출하시겠습니까?")){
				document.frm.submit();
				}
			}
		}
</script>
</head>
<body>
<form action="inputAction.do" name = "frm">
<h2 align="center">성적입력</h2>
	<table border="1" style="border-collapse: collapse; align-content: center;">
		<tr>
			<th>학번</th>
			<td><input type="text" name="hakbun"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><input type="text" name="kor"></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><input type="text" name="eng"></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><input type="text" name="mat"></td>
		</tr>
		<tr>
			<th>한국사</th>
			<td><input type="text" name="his"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="입력" onclick="check()">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>