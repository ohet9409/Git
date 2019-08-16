class Outer4{
	int x =40;
	public void ex1() {
		x =50;
	}
	public void disp() {
		System.out.println("TEST");
	}
}
class Sub4 extends Outer4{
	@Override
	public void disp() {
		System.out.println("x = " + x);
	}
}
public class Exam4 {

	public static void main(String[] args) {
		Sub4 sub4 = new Sub4();
		sub4.disp();
		
		Outer4 outer4 = new Outer4() {
			int y = 50;
			@Override
			public void disp() {
				ex1();
				System.out.println("x = " + x);
				System.out.println("y = " + y);
			}
		};
		outer4.disp();
	}

}
