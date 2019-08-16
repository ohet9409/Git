package test;

import java.util.Scanner;

// 객체 배열
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Controller controller = new Controller();
		
		while (true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 종료");
			System.out.println("-------");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				controller.input();
				break;
			case 2:
				controller.output();
				break;
			case 3:
				System.out.println("프로그램 종료");
				System.exit(0);

			}
			System.out.println();
		}
	}
}
