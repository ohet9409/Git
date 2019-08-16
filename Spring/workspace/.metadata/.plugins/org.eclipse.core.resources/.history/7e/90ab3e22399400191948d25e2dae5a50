package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm() {
		System.out.println("글저장 화면");
		// 1) 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
	
		//return "boardWriteForm";	// ./boardWriteForm.jsp
		return modelAndView;
	}
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
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
		//BoardDAO dao = new BoardDAO();
		int su = boardService.boardWrtie(dto);
		// 3) 데이터 공유
		request.setAttribute("su", su);
		// 4) 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWrite.jsp");
		modelAndView.addObject("su", su);
		//return "boardWrite";	// ./boardWrite.jsp
		return modelAndView;
	}
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
    	System.out.println("글 목록보기");
		// 1) 데이터 처리
    	int pg = 1;
    	if(request.getParameter("pg") != null){
    		pg = Integer.parseInt(request.getParameter("pg"));
    	}
    	// 2) 목록처리 (5줄씩)
    	int endNum = pg*5;
    	int startNum = endNum-4;
    	
    	//BoardDAO dao = new BoardDAO();
    	List<BoardDTO> list = boardService.boardList(startNum, endNum);
    
    	// 3) 페이징 처리
    	int count = boardService.count();	// 총목록수
    	int totalP = (count+4)/5;	// 총 페이지수
    	
    	int startPage = (pg-1)/3*3+1;
    	int endPage = startPage+2;
    	if(endPage > totalP){
    		endPage = totalP;
    	}
    	// 4) 데이터 공유 처리
    	ModelAndView modelAndView = new ModelAndView();
    	// ModelAndView 클래스에 공유데이터 저장
    	modelAndView.addObject("pg", pg);
    	modelAndView.addObject("list", list);
    	modelAndView.addObject("startPage", startPage);
    	modelAndView.addObject("endPage",endPage);
    	modelAndView.addObject("totalP", totalP);
    	// ModelAndView 클래스에 화면네비게이션 정보를 저장
    	modelAndView.setViewName("boardList.jsp");
		/*
		 * request.setAttribute("pg", pg); request.setAttribute("endNum", endNum);
		 * request.setAttribute("startNum", startNum); request.setAttribute("count",
		 * count); request.setAttribute("totalP", totalP);
		 * request.setAttribute("startPage", startPage); request.setAttribute("endPage",
		 * endPage); request.setAttribute("list", list);
		 */
    	// 5) 화면 네비게이션
    	
    	//return "boardList"; // ./boardList.jsp
    	return modelAndView;
	}
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		System.out.println("상세보기");
		// 1) 데이터 처리
		HttpSession session = request.getSession();
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2) DB
		//BoardDAO dao = new BoardDAO();
		int su = boardService.countHit(seq);
		BoardDTO dto = boardService.boardView(seq);
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
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		System.out.println("글 삭제");
		// 1) 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2) DB
		//BoardDAO dao = new BoardDAO();
		int su = boardService.boardDelete(seq);
		// 3) 데이터 공유
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("su", su);
		// 4) 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardDelete.jsp");
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("su", su);
		//return "boardDelete";  // ./boardDelete.jsp
		return modelAndView;
	}
}
