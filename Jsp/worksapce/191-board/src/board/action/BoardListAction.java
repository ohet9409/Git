package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		String forward = null;
		int pg = 1;
		if(request.getParameter("pg") != null) {
			pg=Integer.parseInt(request.getParameter("pg"));
		}
		int endNum = pg*10;
		int startNum = endNum-9;
		BoardDAO boardDAO = new BoardDAO();
		List<BoardBean> list = boardDAO.selectArticleList(startNum, endNum);
		// 페이징 처리
		int totalA = boardDAO.total();	// 총 글갯수
		int totalP = (totalA + 9)/10;	// 총 페이지수
		
		int startPage = (pg-1)/3*3+1;
		int endPage = startPage+2;
		if(endPage>totalP)
			endPage=totalP;
		// 데이터 공유
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
//				int su=(int)request.getAttribute("su");
//				request.setAttribute("su", su);
		// 공유된 데이터 처리용 view(jsp) 파일
		return "/board/boardList.jsp";
	}

}
