package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;
import member.dao.MemberDAO;


public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DispatcherServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트 요청 정보 추출
		String uri = request.getRequestURI();
		//String uri = request.getServletPath();
		// uri = /step11/member/login.do
		System.out.println("uri = " + uri);
		// 뒤에서 부터 "/"를 찾아서 그 부분까지 잘라내기
		String path = uri.substring(uri.lastIndexOf("/"));
		// path = /login.do
		System.out.println("path = " + path);
		// 2. 데이터 처리 : 1) 데이터 처리  	2) view 처리용 jsp 파일 선택
		String viewPage = "";		// view 처리 jsp 파일 이름 저장
		
		if(path.equals("/login.do")) {
			System.out.println("로그인 처리");
			// 1) 사용자 입력 정보 추출
			request.setCharacterEncoding("utf-8");
	    	String id = request.getParameter("id");
	    	String pwd = request.getParameter("pwd");
	    	// 2) DB 처리
	    	MemberDAO dao = new MemberDAO();
	    	String name = dao.login(id, pwd);
	    	// 3) 화면 네비게이션
	    	if(name != null){	// log on 상태
	    		HttpSession session = request.getSession();
	    		session.setAttribute("memId", id);
	    		session.setAttribute("memName", name);
	    		viewPage = "/board/boardList.do?pg=1";
	    		//response.sendRedirect("../board/boardList.jsp?pg=1");
	    	} else {			// log off 상태
	    		viewPage = "loginForm.jsp";
	    		//response.sendRedirect("loginForm.jsp");
	    	}
		} else if(path.equals("/boardList.do")) {
			request.setCharacterEncoding("utf-8");
	    	// 1) 데이터 처리
	    	int pg = 1;
	    	if(request.getParameter("pg") != null){
	    		pg = Integer.parseInt(request.getParameter("pg"));
	    	}
	    	// 2) 목록처리 (5줄씩)
	    	int endNum = pg*5;
	    	int startNum = endNum-4;
	    	
	    	BoardDAO dao = new BoardDAO();
	    	List<BoardDTO> list = dao.boardList(startNum, endNum);
	    
	    	// 3) 페이징 처리
	    	int count = dao.count();	// 총목록수
	    	int totalP = (count+4)/5;	// 총 페이지수
	    	
	    	int startPage = (pg-1)/3*3+1;
	    	int endPage = startPage+2;
	    	if(endPage > totalP){
	    		endPage = totalP;
	    	}
	    	// 4) 데이터 공유 처리
	    	request.setAttribute("pg", pg);
	    	request.setAttribute("endNum", endNum);
	    	request.setAttribute("startNum", startNum);
	    	request.setAttribute("count", count);
	    	request.setAttribute("totalP", totalP);
	    	request.setAttribute("startPage", startPage);
	    	request.setAttribute("endPage", endPage);
	    	request.setAttribute("list", list);
	    	// 5) 화면 네비게이션
	    	viewPage = "../board/boardList.jsp?pg=1";
		} else if(path.equals("/boardView.do")) {
			// 1) 데이터 처리
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
	    	int seq = Integer.parseInt(request.getParameter("seq"));
	    	int pg = Integer.parseInt(request.getParameter("pg"));
	    	
	    	// 2) DB
	    	BoardDAO dao = new BoardDAO();
	    	int su = dao.countHit(seq);
	    	BoardDTO dto = dao.boardView(seq);
	    	String id = (String)session.getAttribute("memId");
	    	// 3) 데이터 공유
	    	request.setAttribute("seq", seq);
	    	request.setAttribute("pg", pg);
	    	request.setAttribute("dto", dto);
	    	request.setAttribute("id", id);
	    	// 4) 화면 네비게이션
	    	viewPage = "../board/boardView.jsp";
		} else if(path.equals("/boardDelete.do")) {
			// 1) 데이터 처리
			int seq = Integer.parseInt(request.getParameter("seq"));
	    	int pg = Integer.parseInt(request.getParameter("pg"));
	    	// 2) DB
	    	BoardDAO dao = new BoardDAO();
	    	int su = dao.boardDelete(seq);
	    	// 3) 데이터 공유
	    	request.setAttribute("seq", seq);
	    	request.setAttribute("pg", pg);
	    	request.setAttribute("su", su);
	    	// 4) 화면 네비게이션
	    	viewPage = "../board/boardDelete.jsp";
		} else if(path.equals("/boardWrite.do")) {
			// 1) 데이터 처리
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
	    	String id = (String)session.getAttribute("memId");
	    	String name = (String)session.getAttribute("memName");
	    	String subject = request.getParameter("subject");
	    	String content = request.getParameter("content");
	    	// 2) DB
	    	BoardDTO dto = new BoardDTO();
	    	dto.setContent(content);
	    	dto.setId(id);
	    	dto.setName(name);
	    	dto.setSubject(subject);
	    	BoardDAO dao = new BoardDAO();
	    	int su = dao.boardWrite(dto);
	    	// 3) 데이터 공유
	    	request.setAttribute("su", su);
	    	// 4) 화면 네비게이션
	    	viewPage = "../board/boardWrite.jsp";
		} else if((path.equals("/boardWriteForm.do"))){
			// 1) 화면 네비게이션
			viewPage = "../board/boardWriteForm.jsp";
		}
		// 3. 화면이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
