package prac7;

import java.util.Scanner;

public class Prac7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		customerlmpl customer = new customerlmpl();
		int num;
		while(true) {
			System.out.println();
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 이름검색");
			System.out.println("5. 종료");
			System.out.println("----------");
			System.out.print("번호 : ");
			num=sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				customer.input();
				System.out.println();
				break;
			case 2:
				customer.output();
				System.out.println();
				break;
			case 3:
				customer.sujung();
				System.out.println();
				break;
			case 4:
				customer.find();
				System.out.println();
				break;
			case 5:
				System.out.println("종료합니다");
				System.exit(0);

			
			}
		}
	}
}
