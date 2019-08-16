package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}

/*public interface Action{
	String process(HttpServletRequest request, HttpServletResponse response);
}*/
		


