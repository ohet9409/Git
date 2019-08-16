package score.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import score.bean.ScoreDTO;
import score.dao.ScoreDAO;
import score.helper.RegexHelper;
@Controller
public class ScoreUpdateController{
	@RequestMapping(value="/score/scoreUpdate.do")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("업");
		int pg = Integer.parseInt(request.getParameter("pg"));
		int su=0;
		String studNo = request.getParameter("studNo");
		String name = request.getParameter("name");
		String kor_num = request.getParameter("kor");
		String eng_num= request.getParameter("eng");
		String mat_num= request.getParameter("mat");
		
		if(!RegexHelper.getinstance().isNum(kor_num) && !RegexHelper.getinstance().isInt(kor_num)) {
			su=-1;
		} else if(!RegexHelper.getinstance().isNum(eng_num) ) {
			su=-1;
		} else if(!RegexHelper.getinstance().isNum(mat_num) ) {
			su=-1;
		}else {
		int kor = Integer.parseInt(kor_num);
		int eng = Integer.parseInt(eng_num);
		int mat = Integer.parseInt(mat_num);
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
		su = dao.scoreUpdate(dto);
		}
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("scoreUpdate.jsp");
    	modelAndView.addObject("su", su);
    	modelAndView.addObject("pg", pg);
    	modelAndView.addObject("studNo", studNo);
    	
		return modelAndView;
		
	}

}
