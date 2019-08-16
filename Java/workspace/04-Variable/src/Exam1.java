
public class Exam1 {
	public static void main(String[] args) {
		// 선언: 변수 만들기
		// 초기화: 1.변수를 만들고 처음으로 데이터를 저장하는 것
		//       2.변수에 데이터를 새롭게 세팅하는 것
		int num1;
		long num2 = 8234567890123456789L;	// long 타입뒤에 L을 안 붙이면 에러가 난다.
		int num3 = 0;
		double num4 = 128.4d;
		float num5 = 128.4f;	// float 타입뒤에 f를 안붙이면 에러가 난다.
		byte num6 = 127;
		short num7 = 250;
		char ch = 'A';
		boolean b = true;
		// 입력: 변수에 데이터 저장하기
		num1 = 100;
		// 연산: 저장된 데이터 가공하기

		// 출력: 결과값 확인하기
		System.out.println("num1 =" + num1);
		System.out.println("num2 =" + num2);
		System.out.println("num3 =" + num3);
		System.out.println("num4 =" + num4);
		System.out.println("num5 =" + num5);
		System.out.println("num6 =" + num6);
		System.out.println("num7 =" + num7);
		System.out.println("ch =" + ch);
		System.out.println("b =" + b);
	}
}
