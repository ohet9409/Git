import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in); // ��ĳ�� ��� �غ�
		String name = null;
		int kor = 0;
		int en = 0;
		int mat = 0;
		int tot = 0;
		// �Է�
		System.out.print("�̸�? ");
		name = sc.next();
		System.out.print("����? ");
		en = sc.nextInt();
		System.out.print("����? ");
		mat = sc.nextInt();
		System.out.print("����? ");
		kor = sc.nextInt();
		// ����
		tot = kor + en + mat;
		// ���
		System.out.println("�̸�: " + name);
		System.out.print("����: " + tot);

	}

}
