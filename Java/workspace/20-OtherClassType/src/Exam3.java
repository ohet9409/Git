
public class Exam3 {

	public static void main(String[] args) {
		int x = 30;
		class AAA{
			int y=40;
			void output() {
				System.out.println("x = "+x);
				System.out.println("y = "+y);
			}
		}
		AAA aaa = new AAA();
		aaa.output();
	}

}
