package customer;

import java.util.Scanner;

public class Prac1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customer customer = new CustomerImpl();
		int num;
		while (true) {
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.println("5. �˻�");
			System.out.println("--------");
			System.out.print("��ȣ�Է� : ");
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
				System.out.println("�����մϴ�");
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
