package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글저장 화면");
		// 1) 화면 네비게이션
		return "boardWriteForm";	// ./boardWriteForm.jsp
	}

}
