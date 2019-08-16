
public class Exam2 {
	public static void main(String[] args) {
		// 선언
		int width = 0;
		final double PI = 3.14; // final : 값 변경 금지
		// 입력
		width = 100;
		// PI = 3.14;
		System.out.println("width = " + width);
		System.out.println("PI = " + PI);
		// 연산
		width = 200;
//		 PI=2.14;  --> 값변경시 에러 발생
		// 출력
		System.out.println("width = " + width);
		System.out.println("PI = " + PI);
	}
}


