// Ŭ���� ���� �Լ��� �̿�
class Calc {
	int plus(int x, int y) {
		return x+y;
	}
	int minus(int x, int y) {
		return x-y;
	}
	int multiply(int x, int y) {
		return x * y;
	}
	int divide(int x, int y) {
		int result = 0;
		if( y != 0) {
			result = x /y;	// ������ 0���� ������ ����
		}return result;
	}
	int f(int x, int y) {
		int result = plus(x, y) + multiply(x, y);	// (x + y) + (x * y)
		return result;
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int p = calc.plus(100, 50);
		System.out.println("100 + 50 = " + p);
		
		System.out.println("100 - 50 = " + calc.minus(100, 50));
		System.out.println("100 * 50 = " + calc.multiply(100, 50));
		System.out.println("100 / 50 = " + calc.divide(100, 50));
		System.out.println("f(100, 50) = " + calc.f(100, 50));
	}
}
