package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("상세보기");
		// 1) 데이터 처리
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2) DB
		BoardDAO dao = new BoardDAO();
		int su = dao.countHit(seq);
		BoardDTO dto = dao.boardView(seq);
		String id = (String)session.getAttribute("memId");
		// 3) 데이터 공유
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("dto", dto);
		request.setAttribute("id", id);
		// 4) 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardView.jsp");
		
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("id", id);
		modelAndView.addObject("dto", dto);
		//return "boardView";  // ./boardView.jsp
		return modelAndView;
	}

}
