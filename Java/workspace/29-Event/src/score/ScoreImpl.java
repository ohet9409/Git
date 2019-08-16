package score;
// Controller : 기능 구현 클래스

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score {
	// 선언
	List<ScoreVO> list = new ArrayList<ScoreVO>();

	// 프로그램 시작시, 파일을 읽어옴 -> 생성자는 자동으로 한번 시작된다.
	public ScoreImpl() {
		readFile();
	}

	// 입력
	@Override
	public void input(ScoreVO vo) {
		list.add(vo); // 리스트에 vo 객체에 입력된 내용을 저장
	}

	// 연산
	@Override
	public String searchHak(String hak) {
		boolean isExist = false;
		String result = "";
		Iterator<ScoreVO> it = list.iterator();
		result = printTitle() + "\n";
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			if (vo.getHak().equals(hak)) {
				result += vo.toString() + "\n"; // 누적
				isExist = true;
			}
		}
		if (isExist == true)
			return result;
		else
			return "해당 되는 사람이 없습니다.";
	}

	@Override
	public String searchName(String name) {
		boolean isExist=false;
		String result = "";
		Iterator<ScoreVO> it = list.iterator();
		result = printTitle() + "\n";
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			if (vo.getName().equals(name)) {
				result += vo.toString() + "\n"; // 누적
				isExist = true;
			}
		}
		if(isExist == true)
		return result; // 누적된 값 돌려주기
		else
			return "해당 되는 사람이 없습니다.";
	}

	@Override
	public void descSortTot() {
		// 정렬 기준
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() { // 무명 클래스 사용(여기서만 사용)

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) { // 정렬 조건을 만드는 함수

				return o1.getTot() < o2.getTot() ? 1 : -1; // 내림차순: 높은 값이 위
			}

		};
		// 정렬
		// Collections.sort(배열 또는 List, 정렬 조건을 가진 객체) --> 정렬해주는 함수
		Collections.sort(list, comparator); // 정렬
		print(); // 정렬된 값을 출력
	}

	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() { // 무명 클래스 사용

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String 클래스가 Comparable<String>을 상속받았기 때문에
				// String 클래스 내부에 compareTo()가 구현되어 있음
				return o1.getHak().compareTo(o2.getHak()); // 작은 값이 위로 --> 문자일때 사용
			}
		};
		// 정렬
		Collections.sort(list, comparator);
		print(); // 출력
	}

	// 출력
	@Override
	public String printTitle() {
		return "학번\t이름\t국어\t영어\t수학\t총점\t평균";

	}

	@Override
	public String print() {
		String result = "";
		result = printTitle() + "\n";
		Iterator<ScoreVO> it = list.iterator();
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			result += vo.toString() + "\n";
//			System.out.println(it.next().toString());
		}
		return result;
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

	public void pgmEnd() {
		System.out.println("프로그램 종료!!");
		writeFile();
		System.exit(0);
	}

}
