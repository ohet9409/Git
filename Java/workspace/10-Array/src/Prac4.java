import java.util.Scanner;

public class Prac4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int hap = 0;
		System.out.print("�迭�� ũ�� : ");
		num = sc.nextInt();
		int[] ar = new int[num];
		// �Է�, �� ���ϱ�
		for (int x = 0; x < ar.length; x++) {
			System.out.printf("ar[%d] : ", x);
			ar[x] = sc.nextInt();
			hap += ar[x];
		}
		// �ִ밪, �ּҰ�
		int max = ar[0];
		int min = ar[0];
		for (int x = 1; x < ar.length; x++) {
			if (max < ar[x]) {
				max = ar[x];
			}
			if (min > ar[x]) {
				min = ar[x];
			}
		}
		// ���
		System.out.println();
		for (int x = 0; x < ar.length; x++) {
			System.out.print(ar[x] + " ");
		}
		System.out.println();
		System.out.println("�� = " + hap);
		System.out.println("�ִ밪 = " + max);
		System.out.println("�ּҰ� = " + min);
	}
}
