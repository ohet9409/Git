
import java.util.Scanner;

public class Prac101 {
	static int input(int[] j) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		for (int x = 1; x <= j.length; x++) {
			System.out.printf("%d�� �л��� ������ �Է� : ", x);
			j[x - 1] = sc.nextInt();
			total += j[x - 1];

		}
		return total;
	}

	static double calc_avg(int total, int[] k) {
		return (double) total / k.length;
		}
	

	static void output(int total, double avg) {
		System.out.println("����: " + total + ", " + "��� : " + avg);
	}

	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int total = 0;
		double avg = 0;
		int[] jumsu = new int[5];
		// �Է�
		total = input(jumsu);
		// ����
		avg = calc_avg(total, jumsu);
		// ���
		output(total, avg);
	}
}
