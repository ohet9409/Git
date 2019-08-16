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
//		System.out.print("국어 점수 입력 : ");
//		int kor = sc.nextInt();
//		return kor;
//	}
//	static int input_eng() {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("영어 점수 입력 : ");
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
		System.out.println(grade(avg) + "학점입니다.");
	}
	static int input(String subject){
		Scanner sc = new Scanner(System.in);
		System.out.print(subject+ "점수 입력 : ");
		int jumsu = sc.nextInt();
		return jumsu;
	}
	public static void main(String[] args) {
		//	선언
		//	main 함수에 있는 변수가 프로그램 작성시 기준이 됨
		//	모든 데이터는 최종적으로 main 함수에 있는 변수에 저장되어야 함.
		int kor = 0, eng = 0, tot;
		double avg;
		//	입력
		kor = input("국어");
		eng = input("영어");
//		kor = input_kor();
//		eng	= input_eng();
		//	연산
		tot = colc_tot(kor,eng);
		avg = colc_avg(tot);
		//	출력
		output(avg);
	}

}
