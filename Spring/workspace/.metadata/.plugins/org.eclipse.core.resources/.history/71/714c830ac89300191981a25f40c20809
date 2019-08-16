package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import board.bean.BoardDTO;
import board.dao.BoardDAO;
@Controller
public class BoardWriteController{
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 저장");
		// 1) 데이터 처리
		HttpSession session = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String id = (String) session.getAttribute("memId");
		String name = (String) session.getAttribute("memName");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// 2) DB
		BoardDTO dto = new BoardDTO();
		dto.setContent(content);
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		BoardDAO dao = new BoardDAO();
		int su = dao.boardWrite(dto);
		// 3) 데이터 공유
		request.setAttribute("su", su);
		// 4) 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWrite.jsp");
		modelAndView.addObject("su", su);
		//return "boardWrite";	// ./boardWrite.jsp
		return modelAndView;
	}

}
