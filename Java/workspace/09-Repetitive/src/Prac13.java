import java.util.Scanner;

public class Prac13 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num = 0; // 번호 저장
		int money = 0; // 입력 금액 저장
		int account = 0; // 잔고 저장
		while (true) {
			// 입력
			System.out.println("1.예금  2.출금  3.잔고   4.종료");
			System.out.print("번호 선택: ");
			num = sc.nextInt();
			// 연산
			switch (num) {
			case 1: // 예금
				System.out.printf("예금액: ");
				money = sc.nextInt();
				account += money;
				money = 0;
				break;

			case 2: // 출금
				System.out.printf("출금액: ");
				money = sc.nextInt();
				account -= money;
				money = 0;
				break;

			case 3: // 잔고
				System.out.println("잔고액: " + account);
				break;

			case 4: // 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			default:
				System.out.println("잘못 입력하셨습니다");
			}
			// 출력
			System.out.println();
		}
	}
}
