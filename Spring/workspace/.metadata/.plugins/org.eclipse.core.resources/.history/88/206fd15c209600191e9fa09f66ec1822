package score.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
@Controller
public class ScoreUpdateFormController {
	@RequestMapping(value="/score/scoreUpdateForm.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String studNo = request.getParameter("studNo");
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		ScoreDAO dao = new ScoreDAO();
		ScoreDTO dto = dao.scoreView(studNo);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("scoreUpdateForm.jsp");
    	modelAndView.addObject("dto", dto);
    	modelAndView.addObject("pg", pg);
		return modelAndView;
		
	}

}
