package exam5;

import java.util.ArrayList;
import java.util.List;

public class Exam5 {

	public static void main(String[] args) {
		ObjectInOut objectInOut = new ObjectInOut();
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동",17,"수원"));
		list.add(new Student("고길동",27,"장흥"));
		list.add(new Student("김철수",37,"울산"));
		list.add(new Student("이영희",25,"강릉"));
		
		// 파일에 저장
		objectInOut.write("student.txt", list);
		// 파일에서 읽어오기
		list= objectInOut.read("student.txt");
		for(int x=0; x<list.size(); x++) {
			Student student = list.get(x);
			System.out.println(student.toString());
		}
	}

}
