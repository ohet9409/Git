package aop01;

public class StartMain {
	public static void main(String[] args) {
		Woman woman = new Woman();
		Man man = new Man();
		
		System.out.println("** 여학생 **");
		woman.classWork();
		System.out.println("-----------");
		System.out.println("** 남학생 **");
		man.classWork();
	}
}
