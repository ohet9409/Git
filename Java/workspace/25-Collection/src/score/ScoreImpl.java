package score;
// Controller : ��� ���� Ŭ����

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ScoreImpl implements Score{
	// ����
	Scanner sc = new Scanner(System.in);
	List<ScoreVO> list = new ArrayList<ScoreVO>();
	// �Է�
	@Override
	public void input() {
		ScoreVO vo = new ScoreVO();
		System.out.print("�й� : ");
		vo.setHak(sc.next());
		System.out.print("�̸� : ");
		vo.setName(sc.next());
		System.out.print("���� : ");
		vo.setKor(sc.nextInt());
		System.out.print("���� : ");
		vo.setEng(sc.nextInt());
		System.out.print("���� : ");
		vo.setMat(sc.nextInt());
		int tot = vo.getKor()+vo.getEng()+vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		list.add(vo);	// ����Ʈ�� vo ��ü�� �Էµ� ������ ����
	}
	// ����
	@Override
	public void searchHak() {
		System.out.print("�˻��� �й� ? ");
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
		System.out.print("�˻��� �̸� : ");
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
		// ���� ����
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				
				return o1.getTot() < o2.getTot() ? 1 : -1;	// ��������
			}
			
		};
		// ����
		Collections.sort(list,comparator);
		print();
	}

	@Override
	public void ascSortHak() {
		Comparator<ScoreVO> comparator = new Comparator<ScoreVO>() {

			@Override
			public int compare(ScoreVO o1, ScoreVO o2) {
				// String Ŭ������ Comparable<String>�� ��ӹ޾ұ� ������
				// String Ŭ���� ���ο� compareTo()�� �����Ǿ� ����
				return o1.getHak().compareTo(o2.getHak()); // ���� ���� ����
			}
		};
		// ����
		Collections.sort(list,comparator);
		print();	// ���
	}
	// ���
	@Override
	public void printTitle() {
		String str = String.format("%s\t %s\t %s\t %s\t %s\t %s\t %s\t ","�й�","�̸�","����","����","����","����","���");
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
