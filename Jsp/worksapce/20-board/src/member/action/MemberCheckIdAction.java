package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.Action;
import member.dao.MemberDAO;

public class MemberCheckIdAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		String id = request.getParameter("id");
		System.out.println(id);
		// DB 처리
		MemberDAO memberDAO = new MemberDAO();
		boolean exist = memberDAO.isExistId(id);
		request.setAttribute("exist", exist);
		request.setAttribute("id", id);
		/* request.setAttribute("req_page", "/member/checkId.jsp"); */
		return "/member/checkId.jsp";
	}

}
