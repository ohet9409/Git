import java.util.Scanner;

public class Prac2 {
	static char grade(double avg) {
		switch ((int) avg / 10) {
		case 10:
		case 9:
			return 'A';

		case 8:
			return 'B';

		case 7:
			return 'C';

		case 6:
			return 'D';

		default:
			return 'F';
		}

	}
	static int input(){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		return a;
	}
//	static int input_kor() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("���� ���� �Է� : ");
//		int kor = sc.nextInt();
//		return kor;
//	}
//	static int input_eng() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("���� ���� �Է� : ");
//		int eng = sc.nextInt();
//		return eng;
//	}
	static int colc_tot(int kor, int eng) {	
		return kor + eng;
	}
	static double colc_avg(int tot){
		return (double)tot/2;
	}
	static void output(double avg) {
		System.out.println(grade(avg) + "�����Դϴ�.");
	}
	static int input(String subject){
		Scanner sc = new Scanner(System.in);
		System.out.print(subject+ "���� �Է� : ");
		int jumsu = sc.nextInt();
		return jumsu;
	}
	public static void main(String[] args) {
		//	����
		//	main �Լ��� �ִ� ������ ���α׷� �ۼ��� ������ ��
		//	��� �����ʹ� ���������� main �Լ��� �ִ� ������ ����Ǿ�� ��.
		int kor = 0, eng = 0, tot;
		double avg;
		//	�Է�
		kor = input("����");
		eng = input("����");
//		kor = input_kor();
//		eng	= input_eng();
		//	����
		tot = colc_tot(kor,eng);
		avg = colc_avg(tot);
		//	���
		output(avg);
	}

}
