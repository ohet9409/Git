import java.util.Scanner;

public class Prac2 {

	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int total = 0;
		double avg = 0;
		// �Է�
		System.out.print("�������� �Է�: ");
		kor = sc.nextInt();
		System.out.print("�������� �Է�: ");
		eng = sc.nextInt();
		// ����
		total = kor + eng;
		avg = (double) total / 2; // ���� (����) �Ǽ� = �Ǽ�
		// ���
		System.out.println("���� = " + total);
		System.out.println("��� = " + avg);
		if (avg >= 90)
			System.out.println("���� = A");
		else if (avg >= 80)
			System.out.println("���� = B");
		else if (avg >= 70)
			System.out.println("���� = C");
		else if (avg >= 60)
			System.out.println("���� = D");
		else
			System.out.println("���� = F");

	}

}
