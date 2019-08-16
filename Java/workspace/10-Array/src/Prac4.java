import java.util.Scanner;

public class Prac4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int hap = 0;
		System.out.print("배열의 크기 : ");
		num = sc.nextInt();
		int[] ar = new int[num];
		// 입력, 합 구하기
		for (int x = 0; x < ar.length; x++) {
			System.out.printf("ar[%d] : ", x);
			ar[x] = sc.nextInt();
			hap += ar[x];
		}
		// 최대값, 최소값
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
		// 출력
		System.out.println();
		for (int x = 0; x < ar.length; x++) {
			System.out.print(ar[x] + " ");
		}
		System.out.println();
		System.out.println("합 = " + hap);
		System.out.println("최대값 = " + max);
		System.out.println("최소값 = " + min);
	}
}
