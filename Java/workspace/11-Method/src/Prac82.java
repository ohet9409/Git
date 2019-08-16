
import java.util.Scanner;

public class Prac82 {
	static int input(String subject){
		Scanner sc = new Scanner(System.in);
		System.out.print(subject + "점수 입력 : ");
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
		
		System.out.println("총점 = " + tot);
		System.out.println("평균 = " + avg);
		System.out.println("학점 = " + hak);
	}
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int tot = 0;
		double avg = 0;
		char hak=0;
		// 입력
		kor = input("국어");
		eng = input("영어");
		// 연산
		tot = calc_tot(kor,eng);
		avg = calc_avg(tot); // 정수 (연산) 실수 = 실수
		hak = calc_hak(avg);
		// 출력
		output(tot,avg,hak);

	}

}
