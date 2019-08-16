import java.util.Scanner;

public class Exam4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = 0;
		char grade = 0;

		System.out.print("점수 입력: ");
		score = sc.nextInt();

		switch (score / 10) {  	// 정수 / 정수 = 정수
		case 10:
		case 9: grade = 'A'; break;  	// 90 ~ 99
		case 8: grade = 'B'; break;		// 80 ~ 89
		case 7: grade = 'C'; break;		// 70 ~ 79
		case 6: grade = 'D'; break;		// 60 ~ 69
		default:  grade = 'F';
		}
		System.out.println(score + "점 "+grade+"학점");
	}
}
