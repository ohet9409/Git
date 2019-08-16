
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
		System.out.println("더하기 : " + sum(3, 5));
		System.out.println("빼 기 : " + sub(7, 2));
		System.out.println("곱하기 : " + mul(4, 5));
		System.out.printf("나누기 : %.2f", div(7, 3));
	}
}
