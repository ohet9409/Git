import java.util.Scanner;

class AAA{
	// 선언  --> 전역 변수
	 Scanner sc = new Scanner(System.in);
	 int a, b, c;

	// 입력
	 void input() {
		System.out.print("정수 입력 : ");
		a = sc.nextInt();
		System.out.print("정수 입력 : ");
		b = sc.nextInt();
	}

	// 연산
	 void plus() {
		c = a + b;
	}

	// 출력
	 void output() {

		System.out.println(c);

	}
	}
	public class Test {
	public static void main(String[] args) {
		// 자동 완성 단축키: ctrl + space
		AAA aa;			// 레퍼런스 변수, 객체
		aa = new AAA();	// new => 1. 변수 만들기 + 함수 만들기	2. 만들어진 변수의 주소를 돌려줌
		aa.input();
		aa.plus();
		aa.output();
		// . => 참조 연산자
	}

}
