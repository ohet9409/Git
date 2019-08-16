package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제");
		// 1) 데이터 처리
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// 2) DB
		BoardDAO dao = new BoardDAO();
		int su = dao.boardDelete(seq);
		// 3) 데이터 공유
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("su", su);
		// 4) 화면 네비게이션
		return "boardDelete";  // ./boardDelete.jsp
	}

}
