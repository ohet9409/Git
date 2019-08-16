package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.controller.Action;

public class LoginOk implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		request.setCharacterEncoding("utf-8");
		//String name = request.getParameter("name");
		//String id = request.getParameter("id");
		
		String name = "";
		String id = "";
		/* 데이터 공유 1 : 쿠키 이용 */
	/*	Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++) {
				if(cookies[i].getName().equals("memName")) {
					name = URLDecoder.decode(cookies[i].getValue(), "UTF-8");
				} else if(cookies[i].getName().equals("memId")) {
					id = cookies[i].getValue();
				}
			}
		}
	*/	
		/* 데이터 공유 2 : 세션 이용 */
		HttpSession session = request.getSession();	// 세션이용
		name = (String)session.getAttribute("memName");
		id = (String)session.getAttribute("memId");
		request.setAttribute("req_page", "/member/loginOk.jsp");
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		return "index.jsp";
	}

}
