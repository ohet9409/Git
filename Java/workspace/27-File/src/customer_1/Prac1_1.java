package customer_1;

import java.util.Scanner;

public class Prac1_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerImpl impl = new CustomerImpl();
		int num;
		while (true) {
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. ����ȣ �˻�");
			System.out.println("4. ���� �˻�");
			System.out.println("5. �̸� �������� ����");
			System.out.println("6. ����ȣ �������� ����");
			System.out.println("7. ���� ����");
			System.out.println("8. ���� �б�");
			System.out.println("9. ����");
			System.out.println("-------------------");
			System.out.print("��ȣ �Է� : ");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			System.out.println();
		}

	}

}
