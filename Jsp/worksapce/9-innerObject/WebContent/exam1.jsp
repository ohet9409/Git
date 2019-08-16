<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function check() {
		if (document.frm.name.value == "") {
			alert("이름을 입력하세요");
		} else{
			document.frm.submit();
		}
	}
</script>
</head>
<body>
	<h1>학번, 이름, 학년, 선택과목을 입력하는 폼</h1>
	<form action="exam1Pro.jsp" method="post" name="frm">
		<table border="1">
			<tr>
				<td align="right"><label>학번:</label></td>
				<td><input type="text" name="hakbun"></td>
			</tr>
			<tr>
				<td align="right"><label>이름:</label></td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td align="right"><label>학년:</label></td>
				<td><input type="radio" name="grade" value="1학년">1학년 <input
					type="radio" name="grade" value="2학년">2학년 <input
					type="radio" name="grade" value="3학년">3학년 <input
					type="radio" name="grade" value="4학년">4학년</td>
			</tr>
			<tr>
				<td align="right"><label>선택과목:</label></td>
				<td><select name="sub">
						<option value="jsp">jsp</option>
						<option value="java">java</option>
						<option value="XML">XML</option>
				</select></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input type="submit" value="입력완료"> <input
					type="button" onclick="check()" value="스크립트"></td>
			</tr>
		</table>

	</form>
</body>
</html>