
public class Prac5 {
	public static void main(String[] args) {
		/*
		 * for(int a=5;a>0;a--) { for(int b=a; b>1; b--) { System.out.print(" "); }
		 * for(int c=6; c>a; c--) { System.out.print("*"); } System.out.println(); }
		 */
		for (int x = 1; x <= 5; x++) { // 5Ãþ
			for (int y = 5 - x; y > 0; y--) {
				System.out.print(" ");
			}
			for (int z = 1; z <= x; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int a = 4; a >= 1; a--) {
			for (int c = 5 - a; c > 0; c--) {
				System.out.print(" ");
			}
			for (int b = 1; b <= a; b++) {
				System.out.print("*");
			}

			System.out.println();
		}
	}
}