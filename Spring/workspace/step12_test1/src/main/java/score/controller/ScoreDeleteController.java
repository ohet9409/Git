package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDAO dao = new ScoreDAO();
		int su = dao.scoreDel(studNo);
		
		request.setAttribute("su", su);
		request.setAttribute("pg", pg);
		return "scoreDelete";
	}

}
