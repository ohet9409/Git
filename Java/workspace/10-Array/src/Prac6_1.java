import java.util.Scanner;

public class Prac6_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] car = new boolean[5]; // �⺻ �ʱⰪ�� false
		int x = 0; // ���� ��ġ
		int menu = 0; // �޴� ��ȣ
		while (true) {
			System.out.println();
			System.out.println("�����������α׷�");
			System.out.println("***********");
			System.out.println("1. ����");
			System.out.println("2. ����");
			System.out.println("3. ����Ʈ");
			System.out.println("4. ����");
			System.out.println("***********");
			System.out.print("�޴� : ");
			menu = sc.nextInt();
			switch (menu) {
			case 1: // ����
				do {
					System.out.printf("��ġ �Է�: ");
					x = sc.nextInt();
				} while (x < 1 || x > 5);
				if ((car[x - 1])) {						// true �� �� ����
					System.out.println((x) + "��ġ���� �̹� ���� �ֽ��ϴ�"); // ��ġ�� ���� �ִ� ���
				} else {
					System.out.println((x) + "��ġ�� ���� / ���� �Ǿ����ϴ�"); // ����ִ� ���
					car[x - 1] = true;
				}
				break;
			case 2: // ����
				do {
					System.out.printf("��ġ �Է�: ");
					x = sc.nextInt();
				} while (x < 1 || x > 5);

				if (car[x - 1]) {								// true�� �� ����
					System.out.println((x) + "��ġ�� �����Ǿ����ϴ�"); // ������ ���� �ִ� ���
					car[x - 1] = false;
				} else {	
					System.out.println((x) + "��ġ�� �����Ǿ� ���� �ʽ��ϴ�."); // ����ִ� ���
				} break;
			case 3: // ����Ʈ
				for (int i = 0; i < car.length; i++) {
					System.out.println((i + 1) + "��ġ : " + car[i]);
				}
				break;
			case 4: // ����
				System.out.println("���α׷��� �����մϴ�");
				System.exit(0);
			default: // �߸� �Է½�
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
				break;
			}

		}
	}
}
