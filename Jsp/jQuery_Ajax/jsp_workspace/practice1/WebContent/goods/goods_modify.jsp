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
	System.out.println("code : " + code);
	int price = 0;
	if(str_price != null){
		if(!str_price.trim().equals("") && str_price.matches("^[0-9]*$")){
			price = Integer.parseInt(str_price);
			System.out.println("price : " + price);
		}
	}
	String maker = request.getParameter("maker");
	System.out.println("maker : " + maker);
	GoodsDTO goodsDTO = new GoodsDTO();
	GoodsDAO goodsDAO = new GoodsDAO();
	goodsDTO.setCode(code);
	goodsDTO.setName(name);
	goodsDTO.setPrice(price);
	goodsDTO.setMaker(maker);
	int result = goodsDAO.goodsUpdate(goodsDTO);
	System.out.println("result : " + result);
	String rt ="";
	if(result >0){
		rt = "OK";
	} else{
		rt = "Fail";
	}
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(rt);
	System.out.println(rt);
%>
