import java.util.Scanner;

// �ֹι�ȣ 7��° �ڸ��� �Է¹��� �� 
public class Prac3 {

	public static void main(String[] args) {
		// ����: ���� �����
		Scanner sc = new Scanner(System.in);
		int ju = 0;
		// �Է�: ������ ������ �����ϱ�
		System.out.print("�ֹι�ȣ 7��° �ڸ��� �Է��ϼ���: ");
		ju = sc.nextInt();
		// ����: ����� ������ �����ϱ�
		// ���: ����� Ȯ���ϱ�
		if (ju == 1)
			System.out.println("����� 1900���� �����̽ʴϴ�");
		else if (ju == 2)
			System.out.println("����� 1900���� �����̽ʴϴ�");
		else if (ju == 3)
			System.out.println("����� 2000���� �����̽ʴϴ�");
		else if (ju == 4)
			System.out.println("����� 2000���� �����̽ʴϴ�");
		else
			System.out.println("1 ~ 4������ ���ڸ� �Է��� �ּ���");

	}

}
