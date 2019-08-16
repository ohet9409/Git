package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import score.dao.ScoreDAO;

public class ScoreDeleteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		
		ScoreDAO dao = new ScoreDAO();
		int su = dao.scoreDel(studNo);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreDelte.jsp");
		modelAndView.addObject("su", su);
		modelAndView.addObject("pg", pg);
		return modelAndView;
	}

}
