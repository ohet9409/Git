import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		// ����: ���� �����
		Scanner sc = new Scanner(System.in);
		String name = null;
		int basePay = 0, salary = 0;
		double tax = 0;
		// �Է�: ������ ������ �����ϱ�
		System.out.print("�̸� �Է�: ");
		name = sc.next();	// ���ڿ� �Է�
		System.out.print("�⺻�� �Է�: ");
		basePay = sc.nextInt();	// ������ �Է�
		// ����: ����� ������ �����ϱ�
		tax = basePay * 0.033;	// �Ǽ��� ����
		salary = (int) (basePay - tax);	// �Ǽ����� ���������� ��ȯ�Ͽ� ����

		System.out.println();

		// ���: ����� Ȯ���ϱ�
		System.out.printf("*** %s�� ����  ***\n", name);
		System.out.println("�⺻��: " + basePay + "��");
		System.out.println("����   : " + (int) tax + "��"); // �Ǽ����� ���������� ��ȯ�Ͽ� ���
		System.out.println("����   : " + salary + "��");
	}
}
