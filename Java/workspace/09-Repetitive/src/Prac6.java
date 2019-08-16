
public class Prac6 {
	public static void main(String[] args) {
		for (int i = 5; i >= 2; i--) { // 5432
			for (int a = 5 - i; a > 0; a--) { // 0123
				System.out.print(" ");
			}
			for (int b = 1; b <= (2 * i - 1); b++) { // 9 7 5 3
				System.out.print("*");
			}

			System.out.println();
		}
		for (int i = 1; i <= 5; i++) {
			for (int a = i; a <= 4; a++) {
				System.out.print(" ");
			}
			for (int b = 1; b <= (2 * i - 1); b++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
