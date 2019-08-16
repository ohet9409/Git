<%@page import="org.json.JSONObject"%>
<%@page import="goods.bean.GoodsDTO"%>
<%@page import="goods.dao.GoodsDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String code = request.getParameter("code");
    	
    	GoodsDTO goodsDTO = new GoodsDTO();
    	GoodsDAO goodsDAO = new GoodsDAO();
    	goodsDTO.setCode(code);
    	int result = goodsDAO.goodsDelete(goodsDTO);
    	System.out.println(code);
    	System.out.println(result);
    	String rt ="";
    	if(result >0){
    		rt = "OK";
    	} else {
    		rt = "Fail";
    	}
    	JSONObject json = new JSONObject();
    	json.put("rt", rt);
    	out.println(rt);
    	System.out.println(rt);
    %>
