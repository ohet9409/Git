<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    	String hakbun = request.getParameter("hakbun");
    	String name = request.getParameter("name");
    	int kor = Integer.parseInt(request.getParameter("kor"));
    	int eng = Integer.parseInt(request.getParameter("eng"));
    	int mat = Integer.parseInt(request.getParameter("mat"));
    	int total = kor + eng + mat;
    	double avg = (double)total/3;
    	
    	ScoreDTO dto = new ScoreDTO();
    	dto.setHakbun(hakbun);
    	dto.setName(name);
    	dto.setKor(kor);
    	dto.setEng(eng);
    	dto.setMat(mat);
    	dto.setTotal(total);
    	dto.setAvg(avg);
    	
    	ScoreDAO dao = new ScoreDAO();
    	int su = dao.inputScore(dto);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<%if(su>0){%>
		alert("저장성공");
		location.href ="scoreList.jsp?pg=1";
	<%} else {%>
		alert("저장실패");
		location.href ="scoreInputForm.jsp";
	<%}%>
</script>
</head>
<body>

</body>
</html>