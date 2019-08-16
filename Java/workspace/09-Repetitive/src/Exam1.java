
public class Exam1 {
	public static void main(String[] args) {
		// 1~100 사이의 5의 배수의 합과 7의 배수의 합을 구함
		long b = 0, c = 0;
		for (long a = 1; a <= 100000; a++) {
			if (a % 5 == 0)
				b += a; // 5의 배수의 합
			if (a % 7 == 0)
				c += a; // 7의 배수의 합
			// System.out.println("a = "+a +", b=" + b);
			// sc.nextLine();
		}
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
