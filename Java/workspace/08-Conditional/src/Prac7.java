import java.util.Scanner;

// a= 중간  b= 기말  c= 과제점수  d= 출석점수  i= 평점  avg= 평균  hak = 학점
public class Prac7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d;
		double i;
		double avg;
		char hak = 0;
		System.out.print("중간고사를 입력하시오: ");
		a = sc.nextInt();
		System.out.print("기말고사를 입력하시오: ");
		b = sc.nextInt();
		System.out.print("과제점수를 입력하시오: ");
		c = sc.nextInt();
		System.out.print("출석점수를 입력하시오: ");
		d = sc.nextInt();
		avg = (a + b) / 2;
		i = (double) ((avg * 0.6) + (c * 0.2) + (d * 0.2));
		System.out.println();
		System.out.printf("성적= %.2f\n", i);
		if (i >= 90) {
			hak = 'A';
			System.out.println("학점-A");
		} else if (i >= 80) {
			hak = 'B';
			System.out.println("학점-B");
		} else if (i >= 70) {
			hak = 'C';
			System.out.println("학점-C");
		} else if (i >= 60) {
			hak = 'D';
			System.out.println("학점-D");
		} else {
			hak = 'F';
			System.out.println("학점-F");
		}
		if ((hak == 'A') || (hak == 'B')) {
			System.out.println("평가=excellent");
		} else if ((hak == 'C') || (hak == 'D')) {
			System.out.println("평가=good");
		} else
			System.out.println("평가=poor");
	}
}
