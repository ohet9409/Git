package customer;

import java.util.Scanner;

public class Prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer customer = new CustomerImpl();
		int num;
		while (true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 정렬");
			System.out.println("4. 종료");
			System.out.println("5. 검색");
			System.out.println("--------");
			System.out.print("번호입력 : ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				customer.input();
				break;
			case 2:
				customer.print();
				break;
			case 3:
				customer.AscSortName();
				break;
			case 4:
				System.out.println("종료합니다");
				System.exit(0);
			case 5:
				customer.searchName();
				break;

			default:
				break;
			}
		}

	}

}
