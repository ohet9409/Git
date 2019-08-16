package prac6;

import java.util.Scanner;

public class Prac6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		int num;
		while(true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 종료");
			System.out.println("------");
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
				System.out.println("종료합니다");
				System.exit(0);

			}
			System.out.println();
		}
		
	}

}
