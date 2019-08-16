import java.util.Scanner;

class Sungjuk{
	// 선언
	Scanner sc = new Scanner(System.in);
	int kor, eng,tot;
	double avg;
	char hak;
	// 입력
	void input(){
		System.out.print("국어점수 입력 : ");
		kor = sc.nextInt();
		System.out.print("영어점수 입력 : ");
		eng = sc.nextInt();
	}
	// 연산
	void calc() {
		tot = kor + eng;
		avg = (double)tot / 2;
		switch ((int)avg /10) {
		case 10: 
		case 9: hak = 'A'; break;
		case 8: hak = 'B'; break;
		case 7: hak = 'C'; break;
		case 6: hak = 'D'; break;
		default: hak = 'F';
		}
	}
	// 출력
	void output() {
		System.out.println("총점 = " + tot);
		System.out.println("평균 = " + avg);
		System.out.println("학점 = " + hak);
	}
}
public class Prac82 {
	public static void main(String[] args) {
		Sungjuk aaa = new Sungjuk();
		aaa.input();
		aaa.calc();
		aaa.output();
	}
}
