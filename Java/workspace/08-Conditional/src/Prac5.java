import java.util.Scanner;

public class Prac5 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int total = 0;
		int avg = 0;
		// �Է�
		System.out.print("�������� �Է�: ");
		kor = sc.nextInt();
		System.out.print("�������� �Է�: ");
		eng = sc.nextInt();
		System.out.print("�������� �Է�: ");
		mat = sc.nextInt();
		// ����
		total = kor + eng + mat;
		avg = total / 3;
		// ���
		if (avg >= 60) {
			if (kor < 40 || mat < 40 || eng < 40) {
				System.out.println("���հ��Դϴ�");
			} else
				System.out.println("�հ��Դϴ�");
		} else
			System.out.println("���հ��Դϴ�");
	}
}
