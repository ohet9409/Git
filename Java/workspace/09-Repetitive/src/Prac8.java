
public class Prac8 {
	public static void main(String[] args) {
		int a = 1; // for�� �ʱⰪ ����
		while (a <= 5) { // 5�� ����
			int b = 1;
			while (b <= a) {
				System.out.print("*");
				b++;
			}
			a++; // for�� ������ ����
			System.out.println();
		}

	}
}
