import java.util.Scanner;

public class Prac2 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int mon = 0;
		int day = 0;
		int num = 0;
		int y = 0;
		int[] year = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// �Է�: ������ ������ �����ϱ�
		System.out.println("**** �ϼ� ���ϱ� ****");
		System.out.print("��: ");
		y = sc.nextInt();
		System.out.print("��: ");
		mon = sc.nextInt();
		System.out.print("��: ");
		day = sc.nextInt();
		// ����: ����� ������ �����ϱ�
		// ���ذ� �������� �Ǵ�
		if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
			year[2] += 1;	// 2���� �ϼ��� 1�� �߰��Ѵ�.
		}
		// month�� 5�� ����� ���: 1~4�� ���� �� ���ϱ�
		for (int x = 0; x < mon; x++) {
			num += year[x];
		}
		// ���: ����� Ȯ���ϱ�
		System.out.printf("1��1�Ϻ��� %d��%d�ϱ����� %d�� �Դϴ�.", mon, day, num + day);

	}
}
