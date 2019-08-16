package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.dao.MemberDAO;

public class MemberDeleteAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		HttpSession session = request.getSession();	// 세션이용
		String id = (String)session.getAttribute("memId");
		MemberDAO memberDAO = new MemberDAO();
		int su = memberDAO.delete(id);
		// 세션 삭제
		session.removeAttribute("memId");
		session.removeAttribute("memName");
		// 데이터 공유
		request.setAttribute("req_page", "/member/delete.jsp");
		request.setAttribute("su", su);
		// view 처리 파일 선택
		return "index.jsp";
	}

}
