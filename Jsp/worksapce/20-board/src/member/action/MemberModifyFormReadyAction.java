package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberModifyFormReadyAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		HttpSession session = request.getSession();	// 세션이용
		String id = (String)session.getAttribute("memId");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.selectOne(id);
		request.setAttribute("req_page", "/member/modifyForm.jsp");
		request.setAttribute("memberDTO", memberDTO);
		request.setAttribute("id", id);
		return "index.jsp";
	}

}
