class Student{
	String name = "ȫ�浿";
	int age = 25;
}
public class Exam1 {
	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("�̸� : " + student.name);
		System.out.println("���� : " + student.age);
		
		student.name = "��ö��";
		student.age = 35;
		System.out.println("�̸� : " + student.name);
		System.out.println("���� : " + student.age);
	}
}
