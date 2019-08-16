package salary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Salary salary = new Salary();
		int num;
		while (true) {
			System.out.println("1. 등록");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 검색");
			System.out.println("5. 종료");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				salary.input(); // 입력
				System.out.println();
				break;
			case 2:
				salary.output(); // 출력
				System.out.println();
				break;
			case 3:
				salary.modify(); // 수정

				System.out.println();
				break;
			case 4:
				salary.search(); // 검색
				System.out.println();
				break;
			case 5:
				System.out.println("종료합니다"); // 종료
				System.exit(0);

			default:
				System.out.println("번호를 잘못 입력했습니다");
				System.out.println();
				break;
			}
		}
	}

}
