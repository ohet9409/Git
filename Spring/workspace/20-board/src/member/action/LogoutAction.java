package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;

public class LogoutAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();	// 세션이용
		// 쿠키 정보 삭제 : 브라우저에게 쿠키정보를 더이상 보내지마라 설정
		/*	Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(int i=0; i<cookies.length; i++) {
					if(cookies[i].getName().equals("memName")) {
						cookies[i].setMaxAge(0);	// 쿠키 삭제 요청
						response.addCookie(cookies[i]);
					} else if(cookies[i].getName().equals("memId")) {
						cookies[i].setMaxAge(0);	// 쿠키 삭제 요청
						response.addCookie(cookies[i]);
					}
				}
			}
		*/	
			// 세션 삭제
			session.removeAttribute("memName");
			session.removeAttribute("memId");
			
			session.invalidate();	// 무효화, 전부 삭제
		request.setAttribute("req_page", "/member/logout.jsp");
		return "index.jsp";
	}

}
