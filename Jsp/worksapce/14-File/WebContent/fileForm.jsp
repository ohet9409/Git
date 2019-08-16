<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일</title>
</head>
<body>	<!-- 파일을 움직일때에는 반드시 post방식으로(용량 문제 때문에) -->
		<!-- enctype="multipart/form-data" : 파일과 문자열을 모두 전송 가능 -->
<form action="fileUpload.jsp" method="post" enctype="multipart/form-data">
	<table border="1" style="border-collapse: collapse;">
		<tr>
			<th width="50">제목</th>
			<td><input type="text" name="subject" size="50" style="width: 380px; "> </td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="15" cols="45" name="content"></textarea> </td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload1" size="50" style="width: 437px; ">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="file" name="upload2" size="50" style="width: 437px; ">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="파일업로드">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>