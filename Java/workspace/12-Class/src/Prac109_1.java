import java.util.Scanner;

class Sub109{
	// 선언
	Scanner sc = new Scanner(System.in);
	final int Num=3;	// 변수의 상수화
	String[] name = new String[Num]; // 레퍼런스 변수의 초기화 : 바로 초기화
	int[][] jumsu; // 국어 , 영어, 수학
	int[] tot; // 총점
	double[] avg; // 평균
	char[] grade; // 학점
	/** 레퍼런스 변수의 초기화 방법 
	 * 1. 함수를 사용하는 방법
	 * 2. 바로 초기화 하는 방법
	 * */ 
	void init() {	//레퍼런스 변수의 초기화 : 함수를 사용
		jumsu = new int[Num][3];
		tot = new int[Num];
		avg = new double[Num];
		grade = new char[Num];
	}
	// 입력
	void input() {
		for(int x = 0; x<Num; x++) { 	// 1행 ~ 3행까지
			System.out.print("이름 : ");
			name[x] = sc.next();
			System.out.print("국어 : ");	
			jumsu[x][0] = sc.nextInt();	// 1행 1열의 국어점수 입력
			System.out.print("영어 : ");
			jumsu[x][1] = sc.nextInt(); // 1행 2열의 영어점수 입력
			System.out.print("수학 : ");
			jumsu[x][2] = sc.nextInt(); // 1행 3열의 수학점수 입력
			System.out.println();

		}
	}
	// 연산
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
	// 출력
	void output() {
		System.out.println("--------------------------------");
		System.out.println("이름     국어     영어     수학     총점     평균     학점");
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
