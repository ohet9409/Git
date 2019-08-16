package exam2.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 데이터 처리 클래스의 역할
// 1. 데이터 처리
// 2. 데이터 공유
// 3. 처리된 결과를 보여줄 jsp 파일 선택
public class MessageNullAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// 2. 데이터 공유
		request.setAttribute("result", "전달된 내용이 없습니다.");
		// 3. 처리된 결과를 보여줄 jsp 파일 선택
		return "messageView.jsp";
	}

}
