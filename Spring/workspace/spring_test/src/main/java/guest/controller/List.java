package guest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import guest.bean.GuestDTO;
import guest.dao.GuestDAO;
@Controller
public class List {
	@Autowired
	private GuestService Service;
	@RequestMapping(value="/guest/list.do")
	public ModelAndView list(HttpServletRequest request) {
		System.out.println("글 목록");
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int endNum = pg*10;
		int startNum = endNum-9;
		
		
		java.util.List<GuestDTO> list = Service.list(startNum, endNum);
		int count = Service.totalA();
		int totalP = (count+9)/10;
		
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage+2;
		if(endPage > totalP) {
			endPage = totalP;
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg", pg);
    	modelAndView.addObject("list", list);
    	modelAndView.addObject("startPage", startPage);
    	modelAndView.addObject("endPage",endPage);
    	modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("display", "../guest/list.jsp");
		modelAndView.setViewName("/main/index.jsp");
		return modelAndView;
		
	}
}
