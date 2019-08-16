package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;

public class ScoreUpdateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("업");
		int pg = Integer.parseInt(request.getParameter("pg"));
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		int tot = kor + eng + mat;
		double avg = tot/3.0;
		ScoreDTO dto = new ScoreDTO();
		dto.setAvg(avg);
		dto.setEng(eng);
		dto.setKor(kor);
		dto.setMat(mat);
		dto.setName(name);
		dto.setStudNo(studNo);
		dto.setTot(tot);
		
		
		ScoreDAO dao = new ScoreDAO();
		int su = dao.scoreUpdate(dto);
		
		request.setAttribute("su", su);
		request.setAttribute("pg", pg);
		return "scoreUpdate";
	}

}
