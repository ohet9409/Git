package score;
// Controller : ��� ���� Ŭ����

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
	// ����
	List<ScoreVO> list = new ArrayList<ScoreVO>();

	// ���α׷� ���۽�, ������ �о�� -> �����ڴ� �ڵ����� �ѹ� ���۵ȴ�.
	public ScoreImpl() {
		readFile();
	}

	// �Է�
	@Override
	public void input(ScoreVO vo) {
		list.add(vo); // ����Ʈ�� vo ��ü�� �Էµ� ������ ����
	}

	// ����
	@Override
	public String searchHak(String hak) {
		boolean isExist = false;
		String result = "";
		Iterator<ScoreVO> it = list.iterator();
		result = printTitle() + "\n";
		while (it.hasNext()) {
			ScoreVO vo = it.next();
			if (vo.getHak().equals(hak)) {
				result += vo.toString() + "\n"; // ����
				isExist = true;
			}
		}
		if (isExist == true)
			return result;
		else
			return "�ش� �Ǵ� ����� �����ϴ�.";
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
				result += vo.toString() + "\n"; // ����
				isExist = true;
			}
		}
		if(isExist == true)
		return result; // ������ �� �����ֱ�
		else
			return "�ش� �Ǵ� ����� �����ϴ�.";
	}

	@Override
	public void descSortTot() {
		// ���� ����
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() { // ���� Ŭ���� ���(���⼭�� ���)

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) { // ���� ������ ����� �Լ�

				return o1.getTot() < o2.getTot() ? 1 : -1; // ��������: ���� ���� ��
			}

		};
		// ����
		// Collections.sort(�迭 �Ǵ� List, ���� ������ ���� ��ü) --> �������ִ� �Լ�
		Collections.sort(list, comparator); // ����
		print(); // ���ĵ� ���� ���
	}

	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() { // ���� Ŭ���� ���

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String Ŭ������ Comparable<String>�� ��ӹ޾ұ� ������
				// String Ŭ���� ���ο� compareTo()�� �����Ǿ� ����
				return o1.getHak().compareTo(o2.getHak()); // ���� ���� ���� --> �����϶� ���
			}
		};
		// ����
		Collections.sort(list, comparator);
		print(); // ���
	}

	// ���
	@Override
	public String printTitle() {
		return "�й�\t�̸�\t����\t����\t����\t����\t���";

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
		System.out.println("���α׷� ����!!");
		writeFile();
		System.exit(0);
	}

}
