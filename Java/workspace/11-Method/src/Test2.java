
public class Test2 {
	static int d=5;		// ����Լ��� �������� ���
	//d = 7;		//�����͸� ���������� ����
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
