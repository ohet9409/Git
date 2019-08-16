<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="goods.dao.GoodsDAO"%>
<%@page import="goods.bean.GoodsDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	GoodsDAO goodsDAO = new GoodsDAO();
	GoodsDTO goodsDTO = goodsDAO.goodsSelect(code);
	String rt = "";
	if (goodsDTO != null) {
		rt = "OK";
	} else {
		rt = "Fail";
	}
	JSONObject json = new JSONObject();
	JSONArray item = new JSONArray();
	JSONObject temp = new JSONObject();
	temp.put("code", goodsDTO.getCode());
	temp.put("name", goodsDTO.getName());
	temp.put("price", goodsDTO.getPrice());
	temp.put("maker", goodsDTO.getMaker());
	item.put(0, temp);
	json.put("item", item);
	out.println(json);
	System.out.println(json);
%>
