
import java.util.Scanner;

public class Prac913 {
	static int inputNum() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1.����  2.���  3.�ܰ�   4.����");
		System.out.print("��ȣ ����: ");
		int num = sc.nextInt();
		return num;
	}

	static int inputCash(int money) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("���ݾ�: ");
		int inputMoney = sc.nextInt();
		money += inputMoney;
		return money;
	}

	static int outputCash(int money) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("��ݾ�: ");
		int outputMoney = sc.nextInt();
		money -= outputMoney;
		return money;
	}

	static void confirmCash(int money) {
		System.out.println("�ܰ��: " + money);
	}

	static void endPgm() {
		System.out.println("���α׷��� �����մϴ�");
		System.exit(0);
	}

	public static void main(String[] args) {
		// ����
		int num = 0; // ��ȣ ����
		int money = 0; // �ܰ� ����

		while (true) {
			// �Է�
			num = inputNum();
			// ����
			switch (num) {
			case 1: // ����
				money = inputCash(money);
				break;
			case 2: // ���
				money = outputCash(money);
				break;

			case 3: // �ܰ�
				confirmCash(money);
				break;

			case 4: // ����
				endPgm();
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			// ���
			System.out.println();
		}
	}
}
