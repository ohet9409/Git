
public class Prac5 {
	static int sum(int a, int b) {

		return a + b;
	}

	static int sub(int a, int b) {

		return a - b;
	}

	static int mul(int a, int b) {

		return a * b;
	}

	static double div(int a, int b) {
		
		return (double)a / b;
	}

	public static void main(String[] args) {
		System.out.println("���ϱ� : " + sum(3, 5));
		System.out.println("�� �� : " + sub(7, 2));
		System.out.println("���ϱ� : " + mul(4, 5));
		System.out.printf("������ : %.2f", div(7, 3));
	}
}
