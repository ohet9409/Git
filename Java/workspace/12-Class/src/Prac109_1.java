import java.util.Scanner;

class Sub109{
	// ����
	Scanner sc = new Scanner(System.in);
	final int Num=3;	// ������ ���ȭ
	String[] name = new String[Num]; // ���۷��� ������ �ʱ�ȭ : �ٷ� �ʱ�ȭ
	int[][] jumsu; // ���� , ����, ����
	int[] tot; // ����
	double[] avg; // ���
	char[] grade; // ����
	/** ���۷��� ������ �ʱ�ȭ ��� 
	 * 1. �Լ��� ����ϴ� ���
	 * 2. �ٷ� �ʱ�ȭ �ϴ� ���
	 * */ 
	void init() {	//���۷��� ������ �ʱ�ȭ : �Լ��� ���
		jumsu = new int[Num][3];
		tot = new int[Num];
		avg = new double[Num];
		grade = new char[Num];
	}
	// �Է�
	void input() {
		for(int x = 0; x<Num; x++) { 	// 1�� ~ 3�����
			System.out.print("�̸� : ");
			name[x] = sc.next();
			System.out.print("���� : ");	
			jumsu[x][0] = sc.nextInt();	// 1�� 1���� �������� �Է�
			System.out.print("���� : ");
			jumsu[x][1] = sc.nextInt(); // 1�� 2���� �������� �Է�
			System.out.print("���� : ");
			jumsu[x][2] = sc.nextInt(); // 1�� 3���� �������� �Է�
			System.out.println();

		}
	}
	// ����
	void calc_tot(){
		for(int x=0; x<Num; x++) {
			tot[x] = jumsu[x][0] +jumsu[x][1] +jumsu[x][2];
		}
	}
	void calc_avg() {
		for(int x = 0 ; x<Num; x++) {
			avg[x] = (double)tot[x]/3;
		}
	}
	void calc_grade() {
		for(int x = 0; x<Num; x++) {
			switch ((int)avg[x]/10) {
			case 10:
			case 9: grade[x] = 'A'; break;
			case 8: grade[x] = 'B'; break;
			case 7: grade[x] = 'C'; break;
			case 6: grade[x] = 'D'; break;
			default: grade[x] = 'F'; break;
			}
		}
	}
	// ���
	void output() {
		System.out.println("--------------------------------");
		System.out.println("�̸�     ����     ����     ����     ����     ���     ����");
		System.out.println("--------------------------------");
		for(int x = 0 ; x<Num; x++) {
			System.out.printf("%3s %2d %2d %2d %2d %.1f %s\n",name[x],jumsu[x][0],jumsu[x][1],jumsu[x][2],tot[x],avg[x],grade[x]);
		}
		System.out.println("--------------------------------");
	}
}
public class Prac109_1 {
	public static void main(String[] args) {
		Sub109 sub109 = new Sub109();
		sub109.init();
		sub109.input();
		sub109.calc_tot();
		sub109.calc_avg();
		sub109.calc_grade();
		sub109.output();
	}
}
