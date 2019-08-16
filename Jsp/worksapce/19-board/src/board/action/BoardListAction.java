package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardListAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		// 데이터 공유
		int su=(int)request.getAttribute("su");
		request.setAttribute("su", su);
		// 공유된 데이터 처리용 view(jsp) 파일
		return "/board/boardList.jsp";
	}

}
