package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardDetailAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		BoardBean bean = new BoardBean();
		BoardDAO dao = new BoardDAO();
		bean=dao.view(board_num);			// 1줄 데이터 출력
		int su = dao.countUp(board_num);	// 조회수 증가
		// 데이터 공유
		request.setAttribute("pg", pg);
		request.setAttribute("board_num", board_num);
		request.setAttribute("bean", bean);
		request.setAttribute("req_page", "/board/boardView.jsp");
		// 공유된 데이터 처리용 view(jsp) 파일
		return "index.jsp";
	}

}
