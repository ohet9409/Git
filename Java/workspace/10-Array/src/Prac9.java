import java.util.Scanner;

public class Prac9 {
	public static void main(String[] args) {
		// ����
		String[] name = new String[3];
		int[][] jumsu = new int[3][3];
		int[] tot = new int[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		// �Է�
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < name.length; i++) {
			System.out.print("�̸�: ");
			name[i] = sc.next();
			System.out.print("����: ");
			jumsu[i][0] = sc.nextInt();
			System.out.print("����: ");
			jumsu[i][1] = sc.nextInt();
			System.out.print("����: ");
			jumsu[i][2] = sc.nextInt();
			tot[i] = jumsu[i][0] + jumsu[i][1] + jumsu[i][2];
			avg[i] = (double) tot[i] / 3;
			switch ((int) avg[i] / 10) {
			case 10:
			case 9:
				grade[i] = 'A';
				break;
			case 8:
				grade[i] = 'B';
				break;
			case 7:
				grade[i] = 'C';
				break;
			case 6:
				grade[i] = 'D';
				break;
			default:
				grade[i] = 'F';
				break;
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------");
		System.out.println("�̸�	����	����	����	����	���	����");

		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s	%3d	%3d	%3d	%3d	%3.1f	%1c\n", name[i], jumsu[i][0], jumsu[i][1], jumsu[i][2],
					tot[i], avg[i], grade[i]);
		}
		System.out.println("--------------------------------------------------------");

	}
}
