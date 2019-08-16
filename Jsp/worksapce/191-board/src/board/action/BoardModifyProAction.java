package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String forward="";
		String realFolder = "";
		String saveFolder ="/boardUpload";
		int fileSize = 5*1024*1024;
		
		realFolder = request.getServletContext().getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder,
				fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		String board_name = multi.getParameter("board_name");
		String board_pass = multi.getParameter("board_pass");
		String board_subject = multi.getParameter("board_subject");
		String board_content = multi.getParameter("board_content");
		String board_file = multi.getOriginalFileName("board_file");
		System.out.println(pg);
		System.out.println(board_num);
		System.out.println(board_name);
		System.out.println(board_pass);
		System.out.println(board_subject);
		System.out.println(board_content);
		System.out.println(board_file);
		
		BoardDAO dao = new BoardDAO();
		BoardBean bean = new BoardBean();
		bean.setBoard_content(board_content);
		bean.setBoard_name(board_name);
		bean.setBoard_pass(board_pass);
		bean.setBoard_subject(board_subject);
		bean.setBoard_file(board_file);
		int su = dao.update(board_num,bean);
		if(su==0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정성공')");
			out.println("</script>");
			forward = "boardDetail.do?pg="+pg+"&board_num="+board_num;
		}
		
		return forward;
		//"boardDetail.do?pg="+pg+"&board_num="+board_num
	}

}
