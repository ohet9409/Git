
public class Prac7 {
	public static void main(String[] args) {
		int count = 0;
		for (long a = 1; a <= 100000; a++) {
			if (a % 3 == 0 && a % 7 == 0) {
				System.out.print(a + " ");
				count++;
			}
			if (count >= 10) {
				System.out.println();
				count = 0;
			}
		}
	}
}
