package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class Logincontroller implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		// 1) 사용자 입력 정보 추출
    	String id = request.getParameter("id");
    	String pwd = request.getParameter("pwd");
    	// 2) DB 처리
    	MemberDAO dao = new MemberDAO();
    	String name = dao.login(id, pwd);
    	// 3) 화면 네비게이션
    	String viewPage ="";
    	if(name != null){	// log on 상태
    		HttpSession session = request.getSession();
    		session.setAttribute("memId", id);
    		session.setAttribute("memName", name);
    		viewPage = "../board/boardList.do?pg=1";
    		//response.sendRedirect("../board/boardList.jsp?pg=1");
    	} else {			// log off 상태
    		viewPage = "loginForm";	//loginForm.jsp
    		//response.sendRedirect("loginForm.jsp");
    	}
		return viewPage;
	}

}
