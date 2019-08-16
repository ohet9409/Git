package exam1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/MessageController")	// 톰캣서버에 서블릿 등록
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	// 1. 웹브라우저의 요청받기 (get 또는 post 방식)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = null;
		String result = null;
		// 2. 요청 정보 확인
		message = request.getParameter("message");
		// 3. 요청 작업 처리
		if(message == null) {
			result = "전달된 내용이 없습니다.";
		} else if(message.equals("host")) {
			result = "고길동 입니다.";
		} else if(message.equals("guest")) {
			result = "홍길동 입니다.";
		} else {
			result = "타입이 맞지 않습니다.";
		}
		// 4. 요청 처리 결과를 request 객체에 저장
		request.setAttribute("result", result);
		// 5. 응답을 위한 view를 선택하고, forward 처리
		RequestDispatcher dispatcher = request.getRequestDispatcher("messageView.jsp");
		dispatcher.forward(request, response);
	}

}
