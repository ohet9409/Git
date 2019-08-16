package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardWriteProAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realFolder ="";
		String saveFolder ="/boardUpload";
		int fileSize = 5*1024*1024;
		realFolder = request.getServletContext().getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder,
				fileSize,"utf-8",new DefaultFileRenamePolicy());
		String forward=null;
		String board_name = multi.getParameter("board_name");
		String board_pass = multi.getParameter("board_pass");
		String board_subject = multi.getParameter("board_subject");
		String board_content = multi.getParameter("board_content");
		String board_file = multi.getOriginalFileName("board_file");
		
		BoardBean bean = new BoardBean();
		bean.setBoard_name(board_name);
		bean.setBoard_pass(board_pass);
		bean.setBoard_subject(board_subject);
		bean.setBoard_content(board_content);
		bean.setBoard_file(board_file);
		BoardDAO dao = new BoardDAO();
		int su = dao.insertArticle(bean);
		if(su >0) {
			forward="boardList.do?pg=1";
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}
	
}
