package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardListAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int pg= 1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		int endNum =pg*10;
		int startNum = endNum-9;
		BoardDAO dao = new BoardDAO();
		List<BoardBean> list =  dao.selectArticleList(startNum, endNum);
		
		int totalA = dao.total();
		int totalP = (totalA+9)/10;
		
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage+2;
		if(endPage > totalP) {
			endPage = totalP;
		}
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("req_page", "/board/boardList.jsp");
		
		return "index.jsp";
	}

}
