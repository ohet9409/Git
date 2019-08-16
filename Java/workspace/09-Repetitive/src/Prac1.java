import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num1 = 0, count = 0;
		// 입력
		System.out.print("1~100 사이의 배수를 구할 숫자 입력: ");
		num1 = sc.nextInt();
		// 연산
		for (int a = 1; a <= 100; a++) {
			if (a % num1 == 0) {
				System.out.print(a + " ");
				count++;
				if(count%10 == 0) {
					System.out.println();
				}
			}
		}
		// 출력
		System.out.println();
		System.out.println("1~100 사이의 " + num1 + "의 배수 개수  = " + count);
	}
}
