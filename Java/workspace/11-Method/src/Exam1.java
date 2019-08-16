
public class Exam1 {
	static void star(int n) {
		for (int a = 1; a <= n; a++) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// 5층 별탑 출력, for문 사용
		for (int i = 1; i <= 5; i++) {
			star(i);

		}
	}
}
