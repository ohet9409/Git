<%@page import="org.json.JSONObject"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String studNo = request.getParameter("studNo");
	String str_kor = request.getParameter("kor");
	int kor=0;
	if(str_kor != null){
		if(!str_kor.trim().equals("") && str_kor.matches("^[0-9]*$")){
			 kor = Integer.parseInt(str_kor);
		}
	}
	String str_eng = request.getParameter("eng");
	int eng=0;
	if(str_eng != null){
		if(!str_eng.trim().equals("") && str_eng.matches("^[0-9]*$")){
			eng = Integer.parseInt(str_eng);
		}
	}
	String str_mat = request.getParameter("mat");
	int mat=0;
	if(str_mat != null){
		if(!str_mat.trim().equals("") && str_mat.matches("^[0-9]*$")){
			mat = Integer.parseInt(str_mat);
		}
	}
	int tot = kor + eng + mat;
	double avg = tot /3.0;
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(studNo);
	scoreDTO.setName(name);
	scoreDTO.setKor(kor);
	scoreDTO.setEng(eng);
	scoreDTO.setMat(mat);
	scoreDTO.setTot(tot);
	scoreDTO.setAvg(avg);
	
	ScoreDAO scoreDAO = new ScoreDAO();
	int result = scoreDAO.scoreInsert(scoreDTO);
	String rt = "";
	if(result >0){
		rt="OK";
	} else{
		rt="Fail";
	}
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(json);
	System.out.println(json);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>