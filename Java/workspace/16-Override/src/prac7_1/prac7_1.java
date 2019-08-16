package prac7_1;

import java.util.Scanner;

public class prac7_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customerimpl customerlmpl = new Customerimpl();
		int num;
		while (true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 검색");
			System.out.println("5. 종료");
			System.out.println("---------");
			System.out.print("번호 : ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				customerlmpl.input();
				System.out.println();
				break;
			case 2:
				customerlmpl.output();
				System.out.println();
				break;
			case 3:
				customerlmpl.modify();
				System.out.println();
				break;
			case 4:
				customerlmpl.search();
				System.out.println();
				break;
			case 5:
				System.out.println("종료합니다");
				System.exit(0);
			default:
				System.out.println("번호를 다시 입력하세요");
				System.out.println();
			}

		}

	}

}
