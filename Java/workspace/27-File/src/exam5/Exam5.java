package exam5;

import java.util.ArrayList;
import java.util.List;

public class Exam5 {

	public static void main(String[] args) {
		ObjectInOut objectInOut = new ObjectInOut();
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("ȫ�浿",17,"����"));
		list.add(new Student("��浿",27,"����"));
		list.add(new Student("��ö��",37,"���"));
		list.add(new Student("�̿���",25,"����"));
		
		// ���Ͽ� ����
		objectInOut.write("student.txt", list);
		// ���Ͽ��� �о����
		list= objectInOut.read("student.txt");
		for(int x=0; x<list.size(); x++) {
			Student student = list.get(x);
			System.out.println(student.toString());
		}
	}

}
