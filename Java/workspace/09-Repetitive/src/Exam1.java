
public class Exam1 {
	public static void main(String[] args) {
		// 1~100 ������ 5�� ����� �հ� 7�� ����� ���� ����
		long b = 0, c = 0;
		for (long a = 1; a <= 100000; a++) {
			if (a % 5 == 0)
				b += a; // 5�� ����� ��
			if (a % 7 == 0)
				c += a; // 7�� ����� ��
			// System.out.println("a = "+a +", b=" + b);
			// sc.nextLine();
		}
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
