
public class Exam2 {
	public static void main(String[] args) {
		/*
		 * ���� ��� for (int a = 2; a < 10; a++) { // 2�� ~ 9�� for (int b = 1; b < 10; b++)
		 * { // 1~9 System.out.printf("%d*%d=%2d ", a, b, a * b); }
		 * System.out.println();
		 * 
		 * }
		 */
		// ���� ���
		for (int b = 1; b < 10; b++) { // 1~9
			for (int a = 2; a < 10; a++) { // 2�� ~ 9��

				System.out.printf("%d*%d=%2d ", a, b, a * b);
			}
			System.out.println();

		}
	}
}
