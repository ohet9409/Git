package prac7_1;

import java.util.Scanner;

public class prac7_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Customerimpl customerlmpl = new Customerimpl();
		int num;
		while (true) {
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. ����");
			System.out.println("4. �˻�");
			System.out.println("5. ����");
			System.out.println("---------");
			System.out.print("��ȣ : ");
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
				System.out.println("�����մϴ�");
				System.exit(0);
			default:
				System.out.println("��ȣ�� �ٽ� �Է��ϼ���");
				System.out.println();
			}

		}

	}

}
