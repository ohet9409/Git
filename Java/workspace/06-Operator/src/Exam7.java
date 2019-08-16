
public class Exam7 {
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		int x = 5;
		int y = 5;

		// 논리 연산에 대한 결과는 boolean 값이다
		boolean r1 = a >= b; // false
		boolean r2 = x >= y; // true
		boolean result1 = r1 && r2; //false : 둘다 true면 true / 하나라도 false면 false
		boolean result2 = r1 || r2;  // true : 둘중 하나만 true면 true
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		
		System.out.println("!result1 : " + !result1);
		System.out.println("!result2 : " + !result2);
	}
}
