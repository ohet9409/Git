import java.util.Scanner;

class AB {
	// ����
	Scanner sc = new Scanner(System.in);
	String[] name = new String[3]; // �̸�
	int[][] jumsu = new int[3][3]; // ���� , ����, ����
	int[] tot = new int[3]; // ����
	double[] avg = new double[3]; // ���
	char[] grade = new char[3]; // ����
	// �Է�

	void input_name(int i) {
			System.out.print("�̸� : ");
			name[i] = sc.next();
	}
	void input_jumsu(int i) {
		
			System.out.print("���� : ");
			jumsu[i][0] = sc.nextInt();
			System.out.print("���� : ");
			jumsu[i][1] = sc.nextInt();
			System.out.print("���� : ");
			jumsu[i][2] = sc.nextInt();
			System.out.println();

	}

	// ����
	void calc_tot(int i) {
			tot[i] = jumsu[i][0] + jumsu[i][1] + jumsu[i][2];
	}
	void calc_avg(int i) {
			avg[i] = (double) tot[i] / 3;
		
	}
	void calc_grade(int i) {
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
		}
	// ���
	void output() {
		System.out.println("------------------------------------------------------");
		System.out.println("�̸�	 ����	 ����	 ����	 ����	 ���	 ����");
		for(int i= 0 ; i<name.length;i++)
		System.out.printf ("%3s	%3d	%3d	%3d	%3d	%.1f	%c\n",name[i],jumsu[i][0],jumsu[i][1],jumsu[i][2],tot[i],avg[i],grade[i]);
		System.out.println("-------------------------------------------------------");
	}
}

public class Prac109 {

	public static void main(String[] args) {
		AB ab = new AB();
		for(int i = 0; i<ab.name.length; i++) {
		ab.input_name(i);
		ab.input_jumsu(i);
		ab.calc_tot(i);
		ab.calc_avg(i);
		ab.calc_grade(i);
		}
		ab.output();
		
		
		
	}
}
