import java.util.Scanner;

public class Prac9_1 {
	public static void main(String[] args) {
		// ����: ���� �����
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3]; // �̸�
		int[][] jumsu = new int[3][3]; // ����, ����, ����
		int[] tot = new int[3]; // ����
		double[] avg = new double[3]; // ���
		char[] grade = new char[3]; // ����
		// �Է�: ������ ������ �����ϱ�
		for (int x = 0; x < name.length; x++) {
			System.out.print("�̸�: ");
			name[x] = sc.next();
			System.out.print("����: ");
			jumsu[x][0] = sc.nextInt();
			System.out.print("����: ");
			jumsu[x][1] = sc.nextInt();
			System.out.print("����: ");
			jumsu[x][2] = sc.nextInt();
		}
		// ����: ����� ������ �����ϱ�
		for(int x=0; x<name.length; x++) {
			// ����
			tot[x] = jumsu[x][0] + jumsu[x][1] + jumsu[x][2];
			// ���
			avg[x] = (double)tot[x]/jumsu.length;
			// ����
			switch((int)avg[x]/10) {
			case 10:
			case 9: grade[x] ='A'; break;
			case 8: grade[x] ='B'; break;
			case 7: grade[x] ='C'; break;
			case 6: grade[x] ='D'; break;
			default: grade[x] ='F'; break;		
			}
		}
		
		// ���: ����� Ȯ���ϱ�

		System.out.println("--------------------------------------------------------");
		System.out.printf("%9s	%6s	%6s %6s %6s %4s %6s\n", "�̸�", "����", "����", "����", "����", "���", "����");

		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%7s	%5d	%5d	%5d	%5d	%3.1f	%5c\n", name[i], jumsu[i][0], jumsu[i][1], jumsu[i][2], tot[i],
					avg[i], grade[i]);
		}
		System.out.println("--------------------------------------------------------");

	}
}
