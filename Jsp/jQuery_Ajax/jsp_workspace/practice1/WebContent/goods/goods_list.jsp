<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="goods.dao.GoodsDAO"%>
<%@page import="java.util.List"%>
<%@page import="goods.bean.GoodsDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	GoodsDAO goodsDAO = new GoodsDAO();
	  List<GoodsDTO> list = goodsDAO.goodsList();
	  int total = list.size();
	  String rt= "";
	  if(total > 0){
		  rt = "OK";
	  } else {
		  rt = "Fail";
	  }
	  
	  JSONObject json = new JSONObject();
	  json.put("rt", rt);
	  json.put("total", total);
	  json.put("item",list);
	  /* if(total > 0){
		  JSONArray item = new JSONArray();
		  for(int i=0; i<list.size(); i++){
			  GoodsDTO goodsDTO = list.get(i);
			  JSONObject temp = new JSONObject();
			  temp.put("code", goodsDTO.getCode());
			  temp.put("name", goodsDTO.getName());
			  temp.put("price", goodsDTO.getPrice());
			  temp.put("maker", goodsDTO.getMaker());
			  item.put(i, temp);
		  }
		  json.put("item", item);
	  } */
	  
	  
	  out.println(json);
	  System.out.println(json);
	  
%>
