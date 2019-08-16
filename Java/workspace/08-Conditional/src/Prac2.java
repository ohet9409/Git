import java.util.Scanner;

public class Prac2 {

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int total = 0;
		double avg = 0;
		// 입력
		System.out.print("국어점수 입력: ");
		kor = sc.nextInt();
		System.out.print("영어점수 입력: ");
		eng = sc.nextInt();
		// 연산
		total = kor + eng;
		avg = (double) total / 2; // 정수 (연산) 실수 = 실수
		// 출력
		System.out.println("총점 = " + total);
		System.out.println("평균 = " + avg);
		if (avg >= 90)
			System.out.println("학점 = A");
		else if (avg >= 80)
			System.out.println("학점 = B");
		else if (avg >= 70)
			System.out.println("학점 = C");
		else if (avg >= 60)
			System.out.println("학점 = D");
		else
			System.out.println("학점 = F");

	}

}
