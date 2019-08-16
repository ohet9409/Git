import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int result1, result2, result3, result4, result5;
		// 입력
		System.out.print("정수입력: ");
		num1 = sc.nextInt();
		System.out.print("정수입력: ");
		num2 = sc.nextInt();
		// 연산
		result1 = num1 + num2; // 더하기 연산자
		result2 = num1 - num2; // 빼기 연산자
		result3 = num1 * num2; // 곱하기 연산자
		result4 = num1 / num2; // 나누기 연산자
		result5 = num1 % num2; // 나머지 연산자
		// 출력
		System.out.printf(" %d + %d = %d\n", num1, num2, result1);
		System.out.printf(" %d - %d = %d\n", num1, num2, result2);
		System.out.printf(" %d * %d = %d\n", num1, num2, result3);
		System.out.printf(" %d / %d = %d\n", num1, num2, result4);
		System.out.printf(" %d %% %d = %d\n", num1, num2, result5);
	}
}
