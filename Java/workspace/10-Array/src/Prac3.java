import java.util.Scanner;

public class Prac3 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int st = 0;
		System.out.print("����� �л����� ������ �Է��Ͻðڽ��ϱ�: ");
		st = sc.nextInt();
		int[] jumsu = new int[st];
		int[] rank = new int[st];
		// �Է�
		for (int i = 0; i < jumsu.length; i++) {
			System.out.print((i + 1) + "�� ���� �Է�: ");
			jumsu[i] = sc.nextInt(); // ���� ����
			rank[i] = 1; // ��� �ʱ�ȭ
		}
		// ����
		for (int i = 0; i < jumsu.length; i++) { // ����
			for (int j = 0; j < jumsu.length; j++) { // ��� ����
				if (jumsu[i] < jumsu[j]) {
					rank[i] += 1;
				}
			}
		}
		// ���
		System.out.println();
		System.out.println("***���***");
		for (int i = 0; i < jumsu.length; i++) {
			System.out.println(jumsu[i] + "�� : " + rank[i] + "��");
		}
	}
}
