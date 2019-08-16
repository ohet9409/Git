package score;
// Controller : 기능 구현 클래스

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	// 선언
	Scanner sc = new Scanner(System.in);
	List<ScoreVO> list = new ArrayList<ScoreVO>();
	// 프로그램 시작시, 파일을 읽어옴
	public ScoreImpl() {
		readFile(); 
	}
	
	// 입력
	@Override
	public void input(ScoreVO vo) {		
		list.add(vo);		
	}
	// 연산
	@Override
	public String searchHak(String hak) {
		String result = "";
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getHak().equals(hak)) {
				result = printTitle()+ "\n";
				result += vo.toString() + "\n";
			}
		}		
		return result;
	}
	@Override
	public String searchName(String name) {
		String result = "";
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getName().equals(name)) {
				result = printTitle() + "\n";
				result += vo.toString() + "\n";
			}
		}
		return result;
	}
	@Override
	public void descSortTot() {
		// 정렬 기준
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return o1.getTot() < o2.getTot() ? 1 : -1;
			}
		};
		// 정렬
		// Collections.sort(배열 또는 List, 정렬 조건을 가진 객체);
		Collections.sort(list, comparator);
		print();
	}	
	@Override
	public void ascSortHak() {
		// 정렬 기준
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String 클래스가 Comparable<String>을 상속받았기 때문에
				// String 클래스 내부에 compareTo()가 구현되어 있음
				return o1.getHak().compareTo(o2.getHak());
			}
		};
		// 정렬
		Collections.sort(list, comparator);		
	}
	// 출력
	@Override
	public String printTitle() {
		return "학번\t이름\t국어\t영어\t수학\t총점\t평균";
//		return String.format("%5s %10s  %4s %4s %4s  %4s %4s", 
//				"학번", "이름", "국어", "영어", "수학", "총점", "평균");		
	}
	@Override
	public String print() {
		String result = "";
		result = printTitle() + "\n";
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			result += vo.toString() + "\n";
		}
		return result;
	}
	
	public void pgmEnd() {
		System.out.println("프로그램 종료!!"); 
		writeFile();
		System.exit(0);
	}
	@Override
	public void readFile() {
		ObjectInOut objectInOut = new ObjectInOut();
		list = objectInOut.read("score.txt");		
	}
	@Override
	public void writeFile() {
		ObjectInOut objectInOut = new ObjectInOut();
		objectInOut.write("score.txt", list);
	}
}






