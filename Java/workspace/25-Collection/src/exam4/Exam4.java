package exam4;

import java.util.ArrayList;
import java.util.List;

import exam4.study.java.model.People;

public class Exam4 {

	public static void main(String[] args) {
		/*	List�� ����ϴ� ���� �Ϲ����� �����
		 * 	�ڹٺ�� �����ϴ� ���̴�.
		 */
		List<People> list = new ArrayList<People>();
		// 10�� �����͸� ����
		for(int x=0; x<10; x++) {
			People people = new People("java ȸ��" + x, "010-1234-567"+x); //10���� people��ü ����
			list.add(people);	// ������ ��ü�� list�� ����(�ּҰ� ����) people ��ü�� �����Ǵ� ���� ������ ���� �������� �ʴ´�
		}
		// ����� ������ Ȯ���ϱ�
		for(int x=0; x<list.size();x++) {
			People people = list.get(x);	//people ��ü�� �ش� list �ּҸ� �޾ƿ´�
			System.out.println(people.toString());	// �ּҿ� �ش��ϴ� ���� ã�Ƽ� ���
		}
	}

}
