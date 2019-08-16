
import java.util.Scanner;

public class Prac101 {
	static int input(int[] j) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for (int x = 1; x <= j.length; x++) {
			System.out.printf("%d번 학생의 점수를 입력 : ", x);
			j[x - 1] = sc.nextInt();
			total += j[x - 1];

		}
		return total;
	}

	static double calc_avg(int total, int[] k) {
		return (double) total / k.length;
		}
	

	static void output(int total, double avg) {
		System.out.println("총점: " + total + ", " + "평균 : " + avg);
	}

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int total = 0;
		double avg = 0;
		int[] jumsu = new int[5];
		// 입력
		total = input(jumsu);
		// 연산
		avg = calc_avg(total, jumsu);
		// 출력
		output(total, avg);
	}
}
