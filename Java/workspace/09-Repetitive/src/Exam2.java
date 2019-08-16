
public class Exam2 {
	public static void main(String[] args) {
		/*
		 * 가로 출력 for (int a = 2; a < 10; a++) { // 2단 ~ 9단 for (int b = 1; b < 10; b++)
		 * { // 1~9 System.out.printf("%d*%d=%2d ", a, b, a * b); }
		 * System.out.println();
		 * 
		 * }
		 */
		// 세로 출력
		for (int b = 1; b < 10; b++) { // 1~9
			for (int a = 2; a < 10; a++) { // 2단 ~ 9단

				System.out.printf("%d*%d=%2d ", a, b, a * b);
			}
			System.out.println();

		}
	}
}
