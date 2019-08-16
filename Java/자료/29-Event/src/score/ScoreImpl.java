package score;
// Controller : ��� ���� Ŭ����

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	// ����
	Scanner sc = new Scanner(System.in);
	List<ScoreVO> list = new ArrayList<ScoreVO>();
	// ���α׷� ���۽�, ������ �о��
	public ScoreImpl() {
		readFile(); 
	}
	
	// �Է�
	@Override
	public void input(ScoreVO vo) {		
		list.add(vo);		
	}
	// ����
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
		// ���� ����
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				return o1.getTot() < o2.getTot() ? 1 : -1;
			}
		};
		// ����
		// Collections.sort(�迭 �Ǵ� List, ���� ������ ���� ��ü);
		Collections.sort(list, comparator);
		print();
	}	
	@Override
	public void ascSortHak() {
		// ���� ����
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {
			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String Ŭ������ Comparable<String>�� ��ӹ޾ұ� ������
				// String Ŭ���� ���ο� compareTo()�� �����Ǿ� ����
				return o1.getHak().compareTo(o2.getHak());
			}
		};
		// ����
		Collections.sort(list, comparator);		
	}
	// ���
	@Override
	public String printTitle() {
		return "�й�\t�̸�\t����\t����\t����\t����\t���";
//		return String.format("%5s %10s  %4s %4s %4s  %4s %4s", 
//				"�й�", "�̸�", "����", "����", "����", "����", "���");		
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
		System.out.println("���α׷� ����!!"); 
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






