package score;
// Controller : 기능 구현 클래스

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	// 선언
	Scanner sc = new Scanner(System.in);
	List<ScoreVO> list = new ArrayList<ScoreVO>();
	// 입력
	@Override
	public void input() {
		ScoreVO vo = new ScoreVO();
		System.out.print("학번 : ");
		vo.setHak(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		int tot = vo.getKor()+vo.getEng()+vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		list.add(vo);	// 리스트에 vo 객체에 입력된 내용을 저장
	}
	// 연산
	@Override
	public void searchHak() {
		System.out.print("검색할 학번 ? ");
		String hak = sc.next();
		
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getHak().equals(hak)) {
				printTitle();
				System.out.println(vo.toString());
			}
		}
		
	}

	@Override
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			if(vo.getName().equals(name)) {
				System.out.println(vo.toString());
			}
		}
		
	}

	@Override
	public void descSortTot() {
		// 정렬 기준
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				
				return o1.getTot() < o2.getTot() ? 1 : -1;	// 내림차순
			}
			
		};
		// 정렬
		Collections.sort(list,comparator);
		print();
	}

	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String 클래스가 Comparable<String>을 상속받았기 때문에
				// String 클래스 내부에 compareTo()가 구현되어 있음
				return o1.getHak().compareTo(o2.getHak()); // 작은 값이 위로
			}
		};
		// 정렬
		Collections.sort(list,comparator);
		print();	// 출력
	}
	// 출력
	@Override
	public void printTitle() {
		String str = String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t ","학번","이름","국어","영어","수학","총점","평균");
		System.out.println(str);
	}

	@Override
	public void print() {
		printTitle();
		Iterator<ScoreVO> it = list.iterator();
		while(it.hasNext()) {
			ScoreVO vo = it.next();
			System.out.println(vo.toString());
		}
		System.out.println();
	}

}
