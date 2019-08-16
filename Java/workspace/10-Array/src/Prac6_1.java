import java.util.Scanner;

public class Prac6_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] car = new boolean[5]; // 기본 초기값은 false
		int x = 0; // 주차 위치
		int menu = 0; // 메뉴 번호
		while (true) {
			System.out.println();
			System.out.println("주차관리프로그램");
			System.out.println("***********");
			System.out.println("1. 입차");
			System.out.println("2. 출차");
			System.out.println("3. 리스트");
			System.out.println("4. 종료");
			System.out.println("***********");
			System.out.print("메뉴 : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1: // 입차
				do {
					System.out.printf("위치 입력: ");
					x = sc.nextInt();
				} while (x < 1 || x > 5);
				if ((car[x - 1])) {						// true 일 때 실행
					System.out.println((x) + "위치에는 이미 차가 있습니다"); // 위치에 차가 있는 경우
				} else {
					System.out.println((x) + "위치에 입차 / 주차 되었습니다"); // 비어있는 경우
					car[x - 1] = true;
				}
				break;
			case 2: // 출차
				do {
					System.out.printf("위치 입력: ");
					x = sc.nextInt();
				} while (x < 1 || x > 5);

				if (car[x - 1]) {								// true일 때 실행
					System.out.println((x) + "위치에 출차되었습니다"); // 기존에 차가 있는 경우
					car[x - 1] = false;
				} else {	
					System.out.println((x) + "위치에 주차되어 있지 않습니다."); // 비어있는 경우
				} break;
			case 3: // 리스트
				for (int i = 0; i < car.length; i++) {
					System.out.println((i + 1) + "위치 : " + car[i]);
				}
				break;
			case 4: // 종료
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			default: // 잘못 입력시
				System.out.println("잘못 입력하셨습니다");
				break;
			}

		}
	}
}
