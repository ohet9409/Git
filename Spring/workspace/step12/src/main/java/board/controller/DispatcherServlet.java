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
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
   
    public DispatcherServlet() {
        super();
       
    }

	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		// "./" : 현재 폴더
		viewResolver.setPrefix("./");
		// 뒤에 .jsp를 붙여주기 위함
		viewResolver.setSuffix(".jsp");
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
		
		// 2. 데이터 처리 : 1) 데이터 처리 클래스 선택 	2) view 처리용 jsp 파일 선택
		// 1) HandlerMapping 클래스를 통해 path에 해당하는 Controller 얻기
		Controller controller = handlerMapping.getController(path);
		// 2) view 처리용 jsp 파일이름 얻기
		String viewName = controller.handleRequest(request, response);		
		System.out.println("viewName = " + viewName);
		// 3. ViewResolver 클래스를 통해 viewName에 해당하는 Jsp 파일 이름 완성값 얻기
		String view = null;
		// contains(".do") : ".do"가 포함된 값을 검사
		if(viewName.contains(".do")) {
			view = viewName;			// "../board/boardList.do?pg=1";
		} else {
			view = viewResolver.getView(viewName);	// "boardList" =>  ./boardList.jsp
		}
		System.out.println("view = " + view);
		/*
		 * if(path.equals("/login.do")) {
		 * 
		 * } else if(path.equals("/boardList.do")) {
		 * 
		 * } else if(path.equals("/boardView.do")) {
		 * 
		 * } else if(path.equals("/boardDelete.do")) {
		 * 
		 * } else if(path.equals("/boardWrite.do")) {
		 * 
		 * } else if((path.equals("/boardWriteForm.do"))){
		 * 
		 * }
		 */
		
		// 3. 화면이동
		if(path.equals("/login.do")) {
			response.sendRedirect(view);	// 폴더가 바뀔 때 사용하면, 경로 설정이 편함
		}else {
			// forward 처리
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}
		
	}

}
