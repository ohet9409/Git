package salary;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Salary salary = new Salary();
		int num;
		while (true) {
			System.out.println("1. ���");
			System.out.println("2. ���");
			System.out.println("3. ����");
			System.out.println("4. �˻�");
			System.out.println("5. ����");
			System.out.print("��ȣ �Է� : ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				salary.input(); // �Է�
				System.out.println();
				break;
			case 2:
				salary.output(); // ���
				System.out.println();
				break;
			case 3:
				salary.modify(); // ����

				System.out.println();
				break;
			case 4:
				salary.search(); // �˻�
				System.out.println();
				break;
			case 5:
				System.out.println("�����մϴ�"); // ����
				System.exit(0);

			default:
				System.out.println("��ȣ�� �߸� �Է��߽��ϴ�");
				System.out.println();
				break;
			}
		}
	}

}
