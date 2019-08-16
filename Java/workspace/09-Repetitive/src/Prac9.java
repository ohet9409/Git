
public class Prac9 {
	public static void main(String[] args) {
		int a = 1;
		while (a <= 5) {
			int b = 5;
			while (b > a) {
				System.out.print(" ");
				b--;
			}
			int c = 1;
			while (c <= a) {
				System.out.print("*");
				c++;
			}
			System.out.println();
			a++;
		}
	}
}
