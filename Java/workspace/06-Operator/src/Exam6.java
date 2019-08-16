import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		// 관계 연산자: 왼쪽 값과 오른쪽 값의 관계를 따져서, 식이 참이면 true, 식이 거짓이면 false
		Scanner sc = new Scanner(System.in);
		int num1 =0, num2=0;
		System.out.print("정수 입력: ");
		num1 = sc.nextInt();
		System.out.print("정수 입력: ");
		num2 = sc.nextInt();
		
		//관계 연산의 결과는 boolean 값이다
		boolean result1 = num1 > num2;
		boolean result2 = num1 < num2;
		boolean result3 = num1 >= num2;
		boolean result4 = num1 <= num2;
		boolean result5 = num1 == num2; // 같은지 검사 -> 같으면 true, 다르면 false
		boolean result6 = num1 != num2; // 다른지 검사 -> 다르면 true, 같으면 false
//		 주석처리 단축키 : ctrl +/
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		System.out.println("result3 = " + result3);
		System.out.println("result4 = " + result4);
		System.out.println("result5 = " + result5);
		System.out.println("result6 = " + result6);
		
	}
}
