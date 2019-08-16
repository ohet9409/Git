import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		// 선언: 변수 만들기
		Scanner sc = new Scanner(System.in);
		String name = null;
		int basePay = 0, salary = 0;
		double tax = 0;
		// 입력: 변수에 데이터 저장하기
		System.out.print("이름 입력: ");
		name = sc.next();	// 문자열 입력
		System.out.print("기본급 입력: ");
		basePay = sc.nextInt();	// 정수형 입력
		// 연산: 저장된 데이터 가공하기
		tax = basePay * 0.033;	// 실수형 연산
		salary = (int) (basePay - tax);	// 실수형을 정수형으로 변환하여 저장

		System.out.println();

		// 출력: 결과값 확인하기
		System.out.printf("*** %s의 월급  ***\n", name);
		System.out.println("기본급: " + basePay + "원");
		System.out.println("세금   : " + (int) tax + "원"); // 실수형을 정수형으로 변환하여 출력
		System.out.println("월급   : " + salary + "원");
	}
}
