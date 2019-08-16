/**
 * 프로그램 소스의 최소 단위 = class 프로그램 시작 클래스 (메인 클래스) --> public class 클래스이름 메인 클래스 이름은
 * 소스파일의 이름과 동일해야 하며, 영어, 숫자, 언더바(_)만 사용 가능하다. 첫 글자는 반드시 영어 대문자로 구성되어야 한다.
 */
public class Exam1 {
	/*
	 * 프로그램의 시작점 --> main 함수(=메소드)
	 */
	public static void main(String[] args) {
		// 콘솔에 문자열을 출력하기 위한 명령어
		// 문자열을 표현하는 방법 --> 쌍따옴표로 묶는다. => "문자열"
		System.out.println("Hello java"); // 모니터에 출력후, 한줄 넘김이 있음
		System.out.print("자바"); // 모니터에 출력후, 한줄 넘김이 없음
		System.out.println(); // 한줄 넘김
		// System.out.print(); //print()는 반드시 출력할 데이터가 있어야 함
		System.out.println("출발");
		// 서식문자: %d %f %c %s
		// %d: 정수
		// %f: 실수
		// %c: 문자
		// %s: 문자열
		// %b: boolean
		// \n: 개행문자(한줄넘김 문자: Enter 역할)
		System.out.printf("%d %f %c %s\n", 5, 7.7, 'A', "홍길동");
		// System.out.printf("%f %d %s %c", 5, 7.7, 'A', "홍길동");

		System.out.println(5);
		System.out.println(5.5);
		System.out.println('A');
		System.out.println("홍길동");
		System.out.println(true);

		System.out.print(5 + " "); // 5공백문자
		System.out.print(5.5 + " "); // 상수 연산
		System.out.print('A' + " ");
		System.out.print("홍길동" + " ");
		System.out.print(true);
	}
}
