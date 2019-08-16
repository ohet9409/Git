package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreModifyFormController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = dao.scoreView(studNo);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreModifyForm.jsp");
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("pg", pg);
		return modelAndView;
	}

}
