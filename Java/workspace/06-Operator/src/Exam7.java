
public class Exam7 {
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		int x = 5;
		int y = 5;

		// �� ���꿡 ���� ����� boolean ���̴�
		boolean r1 = a >= b; // false
		boolean r2 = x >= y; // true
		boolean result1 = r1 && r2; //false : �Ѵ� true�� true / �ϳ��� false�� false
		boolean result2 = r1 || r2;  // true : ���� �ϳ��� true�� true
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		System.out.println("!result1 : " + !result1);
		System.out.println("!result2 : " + !result2);
	}
}
