
public class Test2 {
	static int d=5;		// 모든함수가 공통으로 사용
	//d = 7;		//데이터를 가공하지는 못함
	static void ex1() {
		int b;
		b=7;
		System.out.println("b = " +b);
		d=10;
		System.out.println("d = " +d);
	}
	static void ex2() {
		int c;
		c = 9;
		System.out.println("c = " + c);
		d=20;
		System.out.println("d = " +d);
	}
	public static void main(String[] args) {
		int a;
		
		a=5;
		
		System.out.println("a = " + a);
		d=30;
		System.out.println("d = " +d);
		ex1();
		ex2();
		System.out.println("d = " +d);
	}
}
