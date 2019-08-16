package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.Action;
import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class MemberListAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		int pg =1;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		}
		// DB 처리
		// 목록 5개씩 끊어서 가져오기
		// pg=1	rn>=1 and rn<=5
		// pg=2	rn>=6 and rn<=10
		// pg=3	rn>=11 and rn<=15
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		MemberDAO memberDAO = new MemberDAO();
		List<MemberDTO> list = memberDAO.selectList(startNum, endNum);
		
		/* 페이징 처리
			총회원수 : 12
			총페이지수 : 3
			
			총회원수 : 23
			총페이지수 : 5
			
			총페이지수 = (총회원수 + 4) / 5;
		*/
		int totalMember = memberDAO.getTotalMember();	// 총 회원수
		int totalP = (totalMember + 4) / 5;
		
		/* 3블럭 나눠서 보여주기
			총페이지수 : 8
				 [1][2][3][다음]
			[이전][4][5][6][다음]
			[이전][7][8]
		*/
		int startPage = (pg-1)/3*3 + 1;
		int endPage = startPage + 2;
		if(totalP < endPage) endPage = totalP;
		
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("req_page", "/member/memberList.jsp");
		return "index.jsp";
	}

}
