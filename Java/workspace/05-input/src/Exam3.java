import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in); //System.in: Ű���� �Է�
		String name;
		int kor;
		double height;
		char ch;
		// �Է�
		System.out.print("�̸�: ");
		name = sc.next(); // ���ڿ� 1��
		System.out.print("����: ");
		kor = sc.nextInt(); // ���� 1��
		System.out.print("Ű: ");
		height = sc.nextDouble(); // �Ǽ�1��
		System.out.print("����: ");
		ch = sc.next().charAt(0); // ����1��: Ű������ۿ� ����� ���ڿ��� �о�ͼ�, �� �߿� ���� 1���� �о�� (0:ù��° 1:�ι�°)
		// ����
		// ���
		System.out.println(name + " : " + kor);
		System.out.println("Ű: " + height);
		System.out.println("����: " + ch);
	}
}
