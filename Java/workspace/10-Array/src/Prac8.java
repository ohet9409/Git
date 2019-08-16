
public class Prac8 {
	public static void main(String[] args) {
		// 선언
		int[][] ar = new int[4][4];
		int num = 0;
		int sum2 = 0;
		// 입력
		System.out.println("초기값: ");
		for (int x = 0; x < ar.length; x++) {

			for (int y = 0; y < ar[0].length; y++) {
				if (x == ar.length - 1) {
					ar[x][y] = 0;
					System.out.printf("%2d ", ar[x][y]);
				} else if (y == ar[0].length - 1) {
					ar[x][y] = 0;
					System.out.printf("%2d ", ar[x][y]);
				} else {
					num++;
					ar[x][y] = num;
					System.out.printf("%2d ", ar[x][y]);
				}
			}
			System.out.println();
		}
		System.out.println();
		// 연산
		for (int x = 0; x < 3; x++) { // 행번호: 0~2까지
			for (int y = 0; y < 3; y++) { // 열번호: 열 0~2 까지의 합 구하기
				ar[x][3] += ar[x][y];
				ar[3][x] += ar[y][x];
				ar[3][3] += ar[x][y];
			}
		}
		// 출력
		System.out.println("결과값: ");
		for (int x = 0; x < ar.length; x++) { // a.length: 행의 개수 =>4
			for (int y = 0; y < ar[0].length; y++) { // a[0].length: 열의 개수 =>4
				System.out.printf("%2d ", ar[x][y]);
			}
			System.out.println();
		}

	}
}
