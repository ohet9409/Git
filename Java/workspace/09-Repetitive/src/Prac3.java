import java.util.Scanner;

public class Prac3 {
	public static void main(String[] args) {
		// 선언
		char sun = 0; // 계속 진행할 지 결정하는 문자 저장
		int dan = 0; // 단 저장
		// 입력
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("몇 단을 출력할지 입력하시오: ");
			dan = sc.nextInt();
			// 연산
			// 출력
			for (int a = 1; a <= 9; a++) { // 1~9
				System.out.printf("%d * %d = %d\n", dan, a, dan * a);
			}
			System.out.print("선택하시오(y:계속): ");
			sun = sc.next().charAt(0); 	// 문자 한개 입력 받기
			if (sun != 'y') {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.println();
		}
	}
}
