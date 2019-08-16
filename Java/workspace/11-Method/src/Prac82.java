
import java.util.Scanner;

public class Prac82 {
	static int input(String subject){
		Scanner sc = new Scanner(System.in);
		System.out.print(subject + "���� �Է� : ");
		int jumsu =  sc.nextInt();
		return jumsu;
	}
	static int calc_tot(int kor, int eng){
		return kor + eng;
	}
	static double calc_avg(int total) {
		return (double)total / 2;
	}
	static char calc_hak(double avg) {
		char hak=0;
		if (avg >= 90)
			hak = 'A';
		else if (avg >= 80)
			hak =  'B';
		else if (avg >= 70)
			hak =  'C';
		else if (avg >= 60)
			hak =  'D';
		else
			hak =  'F';
		return hak;
	}
	static void output(int tot, double avg,char hak) {
		
		System.out.println("���� = " + tot);
		System.out.println("��� = " + avg);
		System.out.println("���� = " + hak);
	}
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		char hak=0;
		// �Է�
		kor = input("����");
		eng = input("����");
		// ����
		tot = calc_tot(kor,eng);
		avg = calc_avg(tot); // ���� (����) �Ǽ� = �Ǽ�
		hak = calc_hak(avg);
		// ���
		output(tot,avg,hak);

	}

}
