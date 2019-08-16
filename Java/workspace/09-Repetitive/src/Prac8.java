
public class Prac8 {
	public static void main(String[] args) {
		int a = 1; // for의 초기값 역할
		while (a <= 5) { // 5층 설정
			int b = 1;
			while (b <= a) {
				System.out.print("*");
				b++;
			}
			a++; // for의 증감식 역할
			System.out.println();
		}

	}
}
