import java.util.Scanner;

public class Prac3 {
	public static void main(String[] args) {
		// ����
		char sun = 0; // ��� ������ �� �����ϴ� ���� ����
		int dan = 0; // �� ����
		// �Է�
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("�� ���� ������� �Է��Ͻÿ�: ");
			dan = sc.nextInt();
			// ����
			// ���
			for (int a = 1; a <= 9; a++) { // 1~9
				System.out.printf("%d * %d = %d\n", dan, a, dan * a);
			}
			System.out.print("�����Ͻÿ�(y:���): ");
			sun = sc.next().charAt(0); 	// ���� �Ѱ� �Է� �ޱ�
			if (sun != 'y') {
				System.out.println("���α׷� ����");
				break;
			}
			System.out.println();
		}
	}
}
