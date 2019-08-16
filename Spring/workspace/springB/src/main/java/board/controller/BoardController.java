package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
@Controller
public class BoardController {
	@Autowired
	private BoardService service;
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request) {
		// 데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 5개씩 목록 보여주기
		// (1, 5)
		// (6, 10)
		// (11, 15)
		// (16, 20)	
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		
		List<BoardDTO> list = service.boardList(startNum, endNum);
		
		/* 페이징 처리 (목록은 5줄 씩)
		      총페이지 수 = (총글수 + 4)/5
		    총글수 : 12
		    총페이지수:3		[1][2][3]
		  
		    총글수 : 23
		    총페이지수:5		[1][2][3][4][5]
		*/
		int totalA = service.getTotalA();	// 총글수
		int totalP = (totalA + 4) / 5;	// 총페이지수
		/* 페이지는3개씩 끊어서 보여줌
			총페이지수 : 8
				 [1][2][3][다음]
			[이전][4][5][6][다음]
			[이전][7][8]
		*/
		int startPage = (pg-1)/3*3 + 1;	
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("list",list);
		modelAndView.addObject("endPage",endPage);
		modelAndView.addObject("startPage",startPage);
		modelAndView.addObject("totalP",totalP);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 조회수 증가
		service.updateHit(seq);
		BoardDTO boardDTO = service.boardView(seq);
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("seq",seq);
		modelAndView.addObject("boardDTO",boardDTO);
		
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	@RequestMapping(value="/board/boardModifyForm.do")
	public ModelAndView ModifyForm(HttpServletRequest request) {

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		BoardDTO boardDTO = service.boardView(seq);
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("seq",seq);
		modelAndView.addObject("boardDTO",boardDTO);
		
		modelAndView.setViewName("boardModifyForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardModify.do")
	public ModelAndView Modify(HttpServletRequest request) {
		// 데이터
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 한글 처리
		String pg = request.getParameter("pg");
		int seq = Integer.parseInt(request.getParameter("seq"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// DB
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setSeq(seq);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		
		int su = service.boardModify(boardDTO);
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("seq",seq);
		modelAndView.addObject("su",su);
		modelAndView.addObject("boardDTO",boardDTO);
		
		modelAndView.setViewName("boardModify.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request) {
		// 데이터 처리
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	// 한글처리
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		// DB 처리
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
	
		int su = service.boardWrite(boardDTO);
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("su",su);
		
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}

	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request) {
		
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request) {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		int su = service.boardDelete(seq);
		// 화면 네비게이션
		// ModelAndView = 공유데이터 저장 + view 처리 파일 이름 저장
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("seq",seq);
		modelAndView.addObject("su",su);
		
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}
}
