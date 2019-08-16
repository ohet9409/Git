package score.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import score.dao.ScoreDAO;
import score.dto.ScoreDTO;

public class InputAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String hakbun = request.getParameter("hakbun");
		String name = request.getParameter("name");
		int kor = 0;
		int eng =0;
		int mat=0;
		int his=0;
		if(request.getParameter("kor") != "") {	
			kor = Integer.parseInt(request.getParameter("kor"));
		}
		if(request.getParameter("eng") != "") {	
			eng = Integer.parseInt(request.getParameter("eng"));
		}
		if(request.getParameter("mat") != "") {	
			mat = Integer.parseInt(request.getParameter("mat"));
		}
		if(request.getParameter("his") != "") {	
			his = Integer.parseInt(request.getParameter("his"));
		}
		
		int total = kor + eng + mat + his;
		double avg = (double)total/4;
		ScoreDTO dto = new ScoreDTO();
		dto.setHakbun(hakbun);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMat(mat);
		dto.setHis(his);
		dto.setTotal(total);
		dto.setAvg(avg);
		ScoreDAO dao = new ScoreDAO();
		int su = 0;
		su = dao.inputScore(dto);
		
		request.setAttribute("su", su);
		request.setAttribute("req_page", "/score/inputResult.jsp");
		return "index.jsp";
	}

}
