package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		request.setCharacterEncoding("utf-8");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_lev2 = Integer.parseInt(request.getParameter("board_re_lev2"));
		
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		System.out.println(pg);
		System.out.println(board_num);
		System.out.println(board_re_ref);
		System.out.println(board_re_seq);
		System.out.println(board_re_lev);
		System.out.println("board_re_seq="+board_re_lev2);
		
		BoardBean bean = new BoardBean();
		BoardDAO dao = new BoardDAO();
		bean.setBoard_name(board_name);
		bean.setBoard_pass(board_pass);
		bean.setBoard_subject(board_subject);
		bean.setBoard_content(board_content);
		bean.setBoard_re_ref(board_re_ref);
		bean.setBoard_re_lev(board_re_lev);
		bean.setBoard_re_seq(board_re_seq);
		String forward = "";
		int su = dao.insertReplyArticle(bean);
		if(su == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 저장 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 저장 성공')");
			out.println("</script>");
			forward = "boardList.do?pg="+pg;
		}
		// 데이터 공유
		// view 처리 파일 선택
		return forward;
	}

}
