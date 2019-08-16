package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreUpdateFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = dao.scoreView(studNo);
		
		request.setAttribute("dto", dto);
		request.setAttribute("pg", pg);
		return "scoreUpdateForm";
	}

}
