import java.util.Scanner;

public class Prac9 {
	public static void main(String[] args) {
		// 선언
		String[] name = new String[3];
		int[][] jumsu = new int[3][3];
		int[] tot = new int[3];
		double[] avg = new double[3];
		char[] grade = new char[3];
		// 입력
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < name.length; i++) {
			System.out.print("이름: ");
			name[i] = sc.next();
			System.out.print("국어: ");
			jumsu[i][0] = sc.nextInt();
			System.out.print("영어: ");
			jumsu[i][1] = sc.nextInt();
			System.out.print("수학: ");
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
		System.out.println("이름	국어	영어	수학	총점	평균	학점");

		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%s	%3d	%3d	%3d	%3d	%3.1f	%1c\n", name[i], jumsu[i][0], jumsu[i][1], jumsu[i][2],
					tot[i], avg[i], grade[i]);
		}
		System.out.println("--------------------------------------------------------");

	}
}
