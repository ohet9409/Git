package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		String forward=null;
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String pass = request.getParameter("pass");
		BoardDAO dao = new BoardDAO();
		BoardBean bean = new BoardBean();
		bean = dao.view(board_num);
		// 데이터 공유
		if(bean.getBoard_pass().equals(pass)) {	// 삭제 성공
			int su =dao.del(board_num);
			forward="/boardList.do?pg="+pg;
		}
		else {	// 삭제 실패
			forward="/boardDetail.do?pg="+pg+"&board_num="+board_num;
		}
		// view 처리 파일 선택
		return forward;
	}

}
