import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int num1 = 0, count = 0;
		// �Է�
		System.out.print("1~100 ������ ����� ���� ���� �Է�: ");
		num1 = sc.nextInt();
		// ����
		for (int a = 1; a <= 100; a++) {
			if (a % num1 == 0) {
				System.out.print(a + " ");
				count++;
				if(count%10 == 0) {
					System.out.println();
				}
			}
		}
		// ���
		System.out.println();
		System.out.println("1~100 ������ " + num1 + "�� ��� ����  = " + count);
	}
}
