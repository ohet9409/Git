class Student{
	String name = "È«±æµ¿";
	int age = 25;
}
public class Exam1 {
	public static void main(String[] args) {
		Student student = new Student();
		System.out.println("ÀÌ¸§ : " + student.name);
		System.out.println("³ªÀÌ : " + student.age);
		
		student.name = "±èÃ¶¼ö";
		student.age = 35;
		System.out.println("ÀÌ¸§ : " + student.name);
		System.out.println("³ªÀÌ : " + student.age);
	}
}
