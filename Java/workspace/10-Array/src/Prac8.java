
public class Prac8 {
	public static void main(String[] args) {
		// ����
		int[][] ar = new int[4][4];
		int num = 0;
		int sum2 = 0;
		// �Է�
		System.out.println("�ʱⰪ: ");
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
		// ����
		for (int x = 0; x < 3; x++) { // ���ȣ: 0~2����
			for (int y = 0; y < 3; y++) { // ����ȣ: �� 0~2 ������ �� ���ϱ�
				ar[x][3] += ar[x][y];
				ar[3][x] += ar[y][x];
				ar[3][3] += ar[x][y];
			}
		}
		// ���
		System.out.println("�����: ");
		for (int x = 0; x < ar.length; x++) { // a.length: ���� ���� =>4
			for (int y = 0; y < ar[0].length; y++) { // a[0].length: ���� ���� =>4
				System.out.printf("%2d ", ar[x][y]);
			}
			System.out.println();
		}

	}
}
