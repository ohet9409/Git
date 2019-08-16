
public class Prac10 {
	public static void main(String[] args) {
		int x = 1;
		while (x <= 5) {
			int a = 4;
			while (a >= x) {
				System.out.print(" ");
				a--;
			}
			int b = 1;
			while (b <= (x * 2) - 1) {
				System.out.print("*");
				b++;
			}
			x++;
			System.out.println();
		}
	}
}