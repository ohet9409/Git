
import java.util.Scanner;

public class Prac913 {
	static int inputNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.예금  2.출금  3.잔고   4.종료");
		System.out.print("번호 선택: ");
		int num = sc.nextInt();
		return num;
	}

	static int inputCash(int money) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("예금액: ");
		int inputMoney = sc.nextInt();
		money += inputMoney;
		return money;
	}

	static int outputCash(int money) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("출금액: ");
		int outputMoney = sc.nextInt();
		money -= outputMoney;
		return money;
	}

	static void confirmCash(int money) {
		System.out.println("잔고액: " + money);
	}

	static void endPgm() {
		System.out.println("프로그램을 종료합니다");
		System.exit(0);
	}

	public static void main(String[] args) {
		// 선언
		int num = 0; // 번호 저장
		int money = 0; // 잔고 저장

		while (true) {
			// 입력
			num = inputNum();
			// 연산
			switch (num) {
			case 1: // 예금
				money = inputCash(money);
				break;
			case 2: // 출금
				money = outputCash(money);
				break;

			case 3: // 잔고
				confirmCash(money);
				break;

			case 4: // 종료
				endPgm();
			default:
				System.out.println("잘못 입력하셨습니다");
			}
			// 출력
			System.out.println();
		}
	}
}
