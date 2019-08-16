import java.util.Scanner;

public class Prac5 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int kor = 0;
		int eng = 0;
		int mat = 0;
		int total = 0;
		int avg = 0;
		// 입력
		System.out.print("국어점수 입력: ");
		kor = sc.nextInt();
		System.out.print("영어점수 입력: ");
		eng = sc.nextInt();
		System.out.print("수학점수 입력: ");
		mat = sc.nextInt();
		// 연산
		total = kor + eng + mat;
		avg = total / 3;
		// 출력
		if (avg >= 60) {
			if (kor < 40 || mat < 40 || eng < 40) {
				System.out.println("불합격입니다");
			} else
				System.out.println("합격입니다");
		} else
			System.out.println("불합격입니다");
	}
}
