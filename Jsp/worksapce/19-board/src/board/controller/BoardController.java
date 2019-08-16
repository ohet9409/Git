package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardListAction;
import board.action.BoardWriteProAction;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BoardController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 요청 정보 확인
		String command = request.getServletPath();
		//command = /boardWriteForm.do
		System.out.println("command = " + command);
		/** 데이터 처리  */
		// 요청 작업 처리
		String forward = null; // view 처리용 jsp 파일 이름 저장
		Action action = null;
		if(command.equals("/boardWriteForm.do")) {
			forward = "/board/boardWriteForm.jsp";
		} else if(command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
		} else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
		}
		if(action != null) {
			try {
				forward= action.process(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/** view 처리(HTML 작업) */
		if(forward != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}

}
