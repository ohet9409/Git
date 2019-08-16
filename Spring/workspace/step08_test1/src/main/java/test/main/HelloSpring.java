package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.bean.ScoreVO;
import test.service.ScoreService;

public class HelloSpring {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
		ScoreService service = (ScoreService) context.getBean("scoreServiceImpl");
		ScoreVO vo = new ScoreVO();
		while(true) {
		int no = service.menu();
		switch (no) {
		case 1:
			System.out.print("학번 : ");
			vo.setStudNo(sc.next());
			System.out.print("이름 : ");
			vo.setName(sc.next());
			System.out.print("국어 : ");
			vo.setKor(sc.nextInt());
			System.out.print("영어 : ");
			vo.setEng(sc.nextInt());
			System.out.print("수학 : ");
			vo.setMat(sc.nextInt());
			vo.setTot(vo.getEng() + vo.getKor() + vo.getMat());
			vo.setAvg(vo.getTot()/3.0);
			int su = service.insertScore(vo);
			if(su > 0) {
				System.out.println("저장성공");
			} else {
				System.out.println("저장실패");
			}
			break;
		case 2:
			List<ScoreVO> list = service.listScore()		;
			for(ScoreVO scoreVO : list) {
				System.out.println(scoreVO.toString());
			}
			break;
		case 3:
			System.out.print("수정할 학생코드 : ");
			vo.setStudNo(sc.next());
			System.out.print("수정할 이름 : ");
			vo.setName(sc.next());
			System.out.print("수정할 국어점수 : ");
			vo.setKor(sc.nextInt());
			System.out.print("수정할 수학점수 : ");
			vo.setMat(sc.nextInt());
			System.out.print("수정할 영어점수 : ");
			vo.setEng(sc.nextInt());
			vo.setTot(vo.getEng() + vo.getKor() + vo.getMat());
			vo.setAvg(vo.getTot()/3.0);
			int su1 = service.updateScore(vo);
			if(su1 > 0) {
				System.out.println("수정성공");
			} else {
				System.out.println("수정실패");
			}
			break;
		case 4:
			System.out.println("삭제할 학생코드 : ");
			vo.setStudNo(sc.next());
			int su3 =service.deleteScore(vo);
			if(su3 > 0) {
				System.out.println("삭제성공");
			} else {
				System.out.println("삭제실패");
			}
			break;
		case 5:
			return;

		default:
			System.out.println("1~5선택");
			break;
		}
		context.close();
		}
	}

}
