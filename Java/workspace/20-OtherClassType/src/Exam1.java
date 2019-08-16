class Outer1{
	int x=10;
	void ex1() {
		Inner1 inner1 = new Inner1();
		inner1.output();
	}
	
	class Inner1{
		int y=1;
		void output() {
			System.out.println("x = " + x);
			System.out.println("y = " + y);
		}
	}
}
public class Exam1 {
	public static void main(String[] args) {
		// 사용법1
		Outer1 outer1 = new Outer1();
		Outer1.Inner1 inner1 = outer1.new Inner1();
		inner1.output();
		// 사용법2
		Outer1 outer2 = new Outer1();
		outer2.ex1();
	}
}
