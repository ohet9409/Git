package score.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
import score.helper.RegexHelper;

public class ScoreListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int pg =1;
		String pg_str = request.getParameter("pg");
		
		if(RegexHelper.getinstance().isNum(pg_str)) {
			pg = Integer.parseInt(pg_str);
		}
		/*
    	if(request.getParameter("pg") != null){
    		pg = Integer.parseInt(request.getParameter("pg"));
    	}
    	*/
    	System.out.println("pg="+pg);
    	// 목록 얻기 (5줄)
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	System.out.println("endNum="+endNum);
    	System.out.println("startNum="+startNum);
    	ScoreDAO dao = new ScoreDAO();
    	List<ScoreDTO> list = dao.scoreList(startNum, endNum);
    	// 페이징 데이터 얻기
    	int totalA = dao.scoreCount();
    	int totalP = (totalA+4)/5;
    	
    	int startPage = (pg-1)/3*3+1;
    	int endPage = startPage+2;
    	if(endPage > totalP) {
    		endPage = totalP;
    	}
    	
    	
    	request.setAttribute("totalP", totalP);
    	request.setAttribute("startPage", startPage);
    	request.setAttribute("endPage", endPage);
    	request.setAttribute("pg", pg);
    	request.setAttribute("list", list);
		return "scoreList";
	}

}
