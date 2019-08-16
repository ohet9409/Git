import java.util.Scanner;

public class Prac11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.println("**********");
			System.out.println("1. 입력");
			System.out.println("2. 검색");
			System.out.println("3. 삭제");
			System.out.println("4. 종료");
			System.out.println("**********");
			System.out.print("번호 선택: ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				System.out.println("입력을 선택하셨습니다");
				break;
			case 2:
				System.out.println("검색을 선택하셨습니다");
				break;
			case 3:
				System.out.println("삭제를 선택하셨습니다");
				break;
			case 4:
				System.out.println("프로그램을 종료합니다");
				//break;
				System.exit(0); //-> 프로그램 종료 명령어
			}
			System.out.println();
			/*if (num == 4)
				break; // 스위치, for, while에서만 사용 가능*/
		} while (true);
	}
}
