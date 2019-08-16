
public class Prac4 {
	public static void main(String[] args) {
		//입력
		int a = 0;
		double b = 0.0;
		char c = ' ';
		boolean d = true;
		String e = null;
		//선언
		a = 50;
		b = 178.5;
		c = 'A';
		e = "홍길동";
		//연산
		//출력
		System.out.printf("정수 a = " + a + "\n");
		System.out.printf("실수 b = " + b + "\n");
		System.out.printf("문자 c = " + c + "\n");
		System.out.printf("boolean d = " + d + "\n");
		System.out.printf("문자열 e = " + e);
		System.out.println();
		System.out.println();
		System.out.printf("정수 a = %d\n", a);	// %d = int
		System.out.printf("실수 b = %f\n", b);	// %f = double, float
		System.out.printf("문자 c = %c\n", c);
		System.out.printf("boolean d= %b\n ", d);
		System.out.printf("문자열 e = %s\n", e);	// %s = String
		
		System.out.printf("문자 c 아스키 코드값  = %d\n", (int)c);	// 문자를 int형으로 변환
	}
}
