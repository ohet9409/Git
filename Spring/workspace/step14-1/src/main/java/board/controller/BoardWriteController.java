package board.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteController implements Controller {

	@Override
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
		//return "boardWrite";	// ./boardWrite.jsp
		return modelAndView;
	}

}
