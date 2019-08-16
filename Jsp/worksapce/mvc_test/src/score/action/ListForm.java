package score.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import score.dao.ScoreDAO;
import score.dto.ScoreDTO;

public class ListForm implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int pg = 1;
		if(request.getParameter("pg") != null ) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int endNum = pg*10;
		int startNum = endNum-9;
		ScoreDAO dao = new ScoreDAO();
		List<ScoreDTO> list = dao.list(startNum, endNum);
		int totalScore = dao.count();
		int totalP = (totalScore+9)/10;
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage +2;
		if(totalP < endPage) endPage = totalP;
		System.out.println("totalScore = " +totalScore);
		System.out.println("totalP = " +totalP);
		System.out.println("startPage = "+ startPage);
		System.out.println("endPage = " + endPage);
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("req_page", "/score/list.jsp");
		return "index.jsp";
	}

}
