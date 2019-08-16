package customer_1;

import java.util.Scanner;

public class Prac1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerImpl impl = new CustomerImpl();
		int num;
		while (true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 고객번호 검색");
			System.out.println("4. 고객명 검색");
			System.out.println("5. 이름 내림차순 정렬");
			System.out.println("6. 고객번호 오름차순 정렬");
			System.out.println("7. 파일 저장");
			System.out.println("8. 파일 읽기");
			System.out.println("9. 종료");
			System.out.println("-------------------");
			System.out.print("번호 입력 : ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				impl.input();
				break;
			case 2:
				impl.print();
				break;
			case 3:
				impl.searchNo();
				break;
			case 4:
				impl.searchName();
				break;
			case 5:
				impl.descSortName();
				break;
			case 6:
				impl.ascSortNo();
				break;
			case 7:
				impl.write();
				break;
			case 8:
				impl.read();
				break;
			case 9:
				impl.end();
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
			}
			System.out.println();
		}

	}

}
