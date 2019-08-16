<%@page import="org.json.JSONObject"%>
<%@page import="goods.dao.GoodsDAO"%>
<%@page import="goods.bean.GoodsDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String name = request.getParameter("name");
	String str_price = request.getParameter("price");
	int price = 0;
	if(str_price != null){
		if(!str_price.trim().equals("") && str_price.matches("^[0-9]*$")){
			price = Integer.parseInt(str_price);
		}
	}
	String maker = request.getParameter("maker");
	
	GoodsDTO goodsDTO = new GoodsDTO();
	goodsDTO.setCode(code);
	goodsDTO.setName(name);
	goodsDTO.setPrice(price);
	goodsDTO.setMaker(maker);
	
	GoodsDAO goodsDAO = new GoodsDAO();
	int result = goodsDAO.goodsWrite(goodsDTO);
	String rt = "";
	if(result > 0){
		rt = "OK";
	} else {
		rt = "FAIL";
	}
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(json);
	System.out.println(json);
	
%>
