import java.util.Scanner;
public class Practice2 {
	// ���� ������
	public static void main(String[] args) {
		// ����: ���� �����
		Scanner sc = new Scanner(System.in);
		int money = 0;// �ݾ�
		int oman = 0; // ������
		int man = 0; // ����
		int chun = 0;// õ��
		int baek = 0;// ���
		int ten = 0;// �ʿ�
		int one = 0;// �Ͽ�
		int namugy = 0;// ������
		// �Է�: ������ ������ �����ϱ�
		System.out.print("�ݾ� �Է�: ");
		money = sc.nextInt();
		// ����: ����� ������ �����ϱ�
		oman = money / 50000; // �� ���� 76543��
		namugy = money % 50000;// ������ 26543��
		man = namugy / 10000; // �� ���� 2
		namugy = namugy % 10000;// ������ 6543
		chun = namugy / 1000; // �� ����
		namugy = namugy % 1000;// ������ 543
		baek = namugy / 100; // �� ����
		namugy = namugy % 100;// ������ 43
		ten = namugy / 10; // �� ����
		one = namugy % 10; // ������ 3
		// ���: ����� Ȯ���ϱ�

		System.out.println("�ݾ�: " + money + "��");
		if (oman != 0)
			System.out.println("5����: " + oman + "��");
		if (man != 0)
			System.out.println("����: " + man + "��");
		if (chun != 0)
			System.out.println("õ��: " + chun + "��");
		if (baek != 0)
			System.out.println("���: " + baek + "��");
		if (ten != 0)
			System.out.println("�ʿ�: " + ten + "��");
		if (one != 0)
			System.out.println("�Ͽ�: " + one + "��");
	}
}
