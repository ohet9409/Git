import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int result1, result2, result3, result4, result5;
		// �Է�
		System.out.print("�����Է�: ");
		num1 = sc.nextInt();
		System.out.print("�����Է�: ");
		num2 = sc.nextInt();
		// ����
		result1 = num1 + num2; // ���ϱ� ������
		result2 = num1 - num2; // ���� ������
		result3 = num1 * num2; // ���ϱ� ������
		result4 = num1 / num2; // ������ ������
		result5 = num1 % num2; // ������ ������
		// ���
		System.out.printf(" %d + %d = %d\n", num1, num2, result1);
		System.out.printf(" %d - %d = %d\n", num1, num2, result2);
		System.out.printf(" %d * %d = %d\n", num1, num2, result3);
		System.out.printf(" %d / %d = %d\n", num1, num2, result4);
		System.out.printf(" %d %% %d = %d\n", num1, num2, result5);
	}
}
