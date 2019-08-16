package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyFormAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardBean boardBean = boardDAO.view(board_num);	// 원본글 값 가져오기 
		
		request.setAttribute("pg", pg);
		request.setAttribute("boardBean", boardBean);
		
		return "/board/board_reply.jsp";
	}

}
