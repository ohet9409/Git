import java.util.Scanner;

public class Prac11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		do {
			System.out.println("**********");
			System.out.println("1. �Է�");
			System.out.println("2. �˻�");
			System.out.println("3. ����");
			System.out.println("4. ����");
			System.out.println("**********");
			System.out.print("��ȣ ����: ");
			num = sc.nextInt();
			System.out.println();
			switch (num) {
			case 1:
				System.out.println("�Է��� �����ϼ̽��ϴ�");
				break;
			case 2:
				System.out.println("�˻��� �����ϼ̽��ϴ�");
				break;
			case 3:
				System.out.println("������ �����ϼ̽��ϴ�");
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�");
				//break;
				System.exit(0); //-> ���α׷� ���� ��ɾ�
			}
			System.out.println();
			/*if (num == 4)
				break; // ����ġ, for, while������ ��� ����*/
		} while (true);
	}
}
