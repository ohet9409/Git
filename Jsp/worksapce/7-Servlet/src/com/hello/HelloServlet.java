package com.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HelloServlet() {
        super();
       
    }
    

	 // 톰켓서버가 처음 구동될 때, web.xml에 등록된 서블릿클래스를 실행하는데,
    // 제일 먼저 호출되는 함수
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init() 함수 호출");
	}
	// 톰켓서버가 종료될 때 또는 서블릿이 수정되어 새로이 저장되면,
	// 서블릿이 종료될 때 호출되는 함수
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy() 함수 호출");
	}

	// 클라이언트에게서 요청이 올 때마다 호출, 전송방식이 get 방식일 때
	// request : 요청정보가 저장된 객체
	// response : 응답처리를 담당하는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 함수 호출");
		// 데이터 처리 : request 객체 사용
		// HTML 문서 만들기 : response 객체 사용
		// 이후의 문자열을 HTML로 인식해라
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Hello Servlet</p>");
		out.println("<p>안녕 서블릿!!</p>");
		out.println("</body>");
		out.println("</html>");
	}

	// 클라이언트에게서 요청이 올 때마다 호출, 전송방식이 post 방식일 때
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
