import java.util.Scanner;

public class Prac13 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int num = 0; // ��ȣ ����
		int money = 0; // �Է� �ݾ� ����
		int account = 0; // �ܰ� ����
		while (true) {
			// �Է�
			System.out.println("1.����  2.���  3.�ܰ�   4.����");
			System.out.print("��ȣ ����: ");
			num = sc.nextInt();
			// ����
			switch (num) {
			case 1: // ����
				System.out.printf("���ݾ�: ");
				money = sc.nextInt();
				account += money;
				money = 0;
				break;

			case 2: // ���
				System.out.printf("��ݾ�: ");
				money = sc.nextInt();
				account -= money;
				money = 0;
				break;

			case 3: // �ܰ�
				System.out.println("�ܰ��: " + account);
				break;

			case 4: // ����
				System.out.println("���α׷��� �����մϴ�");
				System.exit(0);
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			// ���
			System.out.println();
		}
	}
}
