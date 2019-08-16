package com.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/PersonServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PersonServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 처리
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] hobby = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String[] subject = request.getParameterValues("subject");
		// HTML 문서 만들기
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet</title>");
		out.println("<style>");
		out.println("li {color: yellow;}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body bgcolor = "+color+">");
		out.println("<ul>");
		out.println("<li>이름: "+name+"</li>");
		out.println("<li>성별: ");
		if (gender.equals("0")) {
			out.println("남자");
		} else
			out.println("남자");
		out.println("</li>");
		out.println("<li>취미 : ");
		if (hobby != null) {
			for(int i=0; i<hobby.length; i++) {
				out.println(hobby[i]+" ");
			}
		}
		out.println("</li>");
		out.println("<li>색깔 : "+color+"</li>");
		out.println("<li>과목 : ");
		if(subject != null) {
		for (String data : subject) {
			out.println(data+" ");
		}
		}
		out.println("</li>");
		out.println("</ul>");
		out.println("<br><br>");
		out.println("<a href= 'javascript:history.go(-1)'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
