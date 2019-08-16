package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardDeleteProAction;
import board.action.BoardDetailAction;
import board.action.BoardListAction;
import board.action.BoardModifyFormAction;
import board.action.BoardModifyProAction;
import board.action.BoardReplyFormAction;
import board.action.BoardReplyProAction;
import board.action.BoardWriteProAction;

@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doprocess(request, response);
	}
	protected void doprocess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1. 요청 정보 확인
		String command = request.getServletPath();
		System.out.println("command = " + command);
		/** 데이터 처리 */
		//2. 요청 작업 처리
		// 		=> 데이터 처리 클래스 선택
		//		=> 데이터 처리
		//  	=> view 처리 파일 선택
		String forward = null;	// view 처리용 jsp 파일 이름 저장
		Action action = null;	// 데이터 처리 클래스 저장
		
		if(command.equals("/boardWriteForm.do")) {
			forward="/board/boardWriteForm.jsp";
		}else if(command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
		} else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
		} else if(command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			
		} else if(command.equals("/boardDeleteForm.do")) {
			forward="/board/board_delete.jsp";
			
		}else if(command.equals("/boardDeletePro.do")) {
			action = new BoardDeleteProAction();
		} else if(command.equals("/boardModifyForm.do")) {
			action = new BoardModifyFormAction();
		} else if(command.equals("/boardModifyPro.do")) {
			action = new BoardModifyProAction();
		} else if(command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();
		} else if(command.equals("/boardReplyPro.do")) {
			action = new BoardReplyProAction();
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
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(forward);
			dispatcher.forward(request, response);
		}
	}
}
















