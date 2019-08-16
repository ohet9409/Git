import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exam2 {

	public static void main(String[] args) {
		// List : ������ �ְ�, ������ �ߺ� �����
		// �迭�� ����� ���
		List<Integer> list = new ArrayList<Integer>();
		// ������ �߰�
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		// �������� ���� ���ϱ�
		System.out.println("������ ���� : " + list.size());
		// 5��° �� ���
		System.out.println("5��° �� : " + list.get(4));
		// 5��° �� ����
		list.remove(4);
		// �������� ���� ���ϱ�
		System.out.println("������ ���� : " + list.size());
		// 5��° �� ���
		System.out.println("5��° �� : " + list.get(4));
		// 3��° ��ġ�� �� �߰��ϱ�
		list.add(2, 123);
		// �������� ���� ���ϱ�
		System.out.println("������ ���� : " + list.size());
		// 5��° �� ���
		System.out.println("5��° �� : " + list.get(4));
		// 5��° �� �����ϱ�
		list.set(4, 500);
		// �������� ���� ���ϱ�
		System.out.println("������ ���� : " + list.size());
		// 5��° �� ���
		System.out.println("5��° �� : " + list.get(4));
		
		// 1. ��ü ������ Ȯ���ϱ�
		System.out.println("1. ��ü ������ Ȯ���ϱ�");
		for(int x=0; x<list.size();x++) {
			System.out.print(x+"��° �� : "+list.get(x)+" ");
		}
		System.out.println();
		// 2. ��ü ������ Ȯ���ϱ�
		// Collection Ŭ������ ��� ����
		System.out.println("2. ��ü ������ Ȯ���ϱ�");
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		// 3. ��ü ������ Ȯ���ϱ�
		// Ȯ�� for�� ��� : �迭�� Collection Ŭ������ ��� ����, �� �߿��� Ŭ������ �Ϲ������� List�� ���� ���
		// for(���� : �迭 or Ŭ����)
		System.out.println();
		System.out.println("3. ��ü ������ Ȯ���ϱ�");
		for(Integer i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
		// ��ü ������ ����
		list.clear();
		// �������� ���� ���ϱ�
		System.out.println("������ ���� : " + list.size());
		// 5��° �� ���
//		System.out.println("5��° �� : " + list.get(4));	-- ���� �����͸� �ҷ����� ������ ����.
	}

}
