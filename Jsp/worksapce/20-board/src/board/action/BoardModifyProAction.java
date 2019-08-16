package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.controller.Action;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String forward=null;
		String realFolder = "";
		String saveFolder ="/boardUpload";
		int fileSize = 5*1024*1024;
		
		realFolder = request.getServletContext().getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder,
				fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		String board_name = multi.getParameter("board_name");
		String board_pass = null;
		System.out.println("board_pass = " + board_pass);
		if(multi.getParameter("board_pass") != null) {
				board_pass = multi.getParameter("board_pass"); // 입력받은 비밀번호
				System.out.println("board_pass = " + board_pass);
		}
		
		String board_subject = multi.getParameter("board_subject");
		String board_content = multi.getParameter("board_content");
		String board_file = multi.getOriginalFileName("board_file");
		System.out.println(pg);
		System.out.println(board_num);
		System.out.println(board_name);
		System.out.println("board_pass = " +board_pass);
		System.out.println(board_subject);
		System.out.println(board_content);
		System.out.println(board_file);
		
		BoardDAO dao = new BoardDAO();
		BoardBean bean = new BoardBean();
		bean = dao.view(board_num);
		String pass = bean.getBoard_pass(); //원래 비밀번호
		
		
		if(pass.equals(board_pass)) {	// 비밀번호가 일치할 경우
			bean.setBoard_content(board_content);
			bean.setBoard_name(board_name);
			bean.setBoard_pass(board_pass);
			bean.setBoard_subject(board_subject);
			bean.setBoard_file(board_file);
			int su = dao.update(board_num,bean); // 글 수정
			System.out.println("su = " +su);
				/*System.out.println("test");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정성공');");
				out.println("</script>");*/
				
				forward = "boardDetail.do?pg="+pg+"&board_num="+board_num;
			
		} else {
			if(board_pass.equals("")) { // 비밀번호 미입력
				/*response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back()");
				out.println("</script>");*/
				// err_no = 1 => 수정실패
				forward = "boardModifyFail.do?board_num="+board_num + "&err_no=1"+"&pg="+pg;
			}else {		// 잘못된 비밀번호 입력
				// err_no = 2 => 수정권한 없음
				forward = "boardModifyFail.do?board_num="+board_num + "&err_no=2"+"&pg="+pg;
			}
		}
		return forward;
	}

}
