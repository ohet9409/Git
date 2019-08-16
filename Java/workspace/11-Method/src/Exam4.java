
public class Exam4 {
	static int sum(int start, int end) {
		int tot = 0;
		for (int x = start; x <= end; x++) {
			tot += x;
		}
		return tot;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 10));
		System.out.println(sum(1, 5));
		System.out.println(sum(1, 100));
	}
}
