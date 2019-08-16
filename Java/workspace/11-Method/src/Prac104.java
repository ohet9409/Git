
import java.util.Scanner;

public class Prac104 {
	static int[] input_size() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기 : ");
		int size = sc.nextInt();
		int[] ar = new int[size];
		return ar;
	}

	static void input_data(int[] ar) {
		Scanner sc = new Scanner(System.in);
		for (int x = 0; x < ar.length; x++) {
			System.out.print("ar[" + x + "] :");
			ar[x] = sc.nextInt();
		}
	}

	static int calc_sum(int[] ar) {
		Scanner sc = new Scanner(System.in);
		int hap = 0;
		for (int x = 0; x < ar.length; x++) {
			hap += ar[x];
		}
		return hap;
	}

	static int calc_max(int[] ar) {
		int max = ar[0];
		for (int x = 1; x < ar.length; x++) {
			if (max < ar[x]) {
				max = ar[x];
			}
		}
		return max;
	}

	static int calc_min(int[] ar) {
		int min = ar[0];
		for (int x = 1; x < ar.length; x++) {
			if (min > ar[x]) {
				min = ar[x];
			}
		}
		return min;
	}

	static void output(int[] ar, int hap, int max, int min) {
		System.out.println();
		for (int x = 0; x < ar.length; x++) {
			System.out.print(ar[x] + " ");
		}
		System.out.println();
		System.out.println("합 = " + hap);
		System.out.println("최대값 = " + max);
		System.out.println("최소값 = " + min);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		int hap = 0;
		int[] ar = null;
		// 입력
		ar = input_size(); // 배열 사이즈 지정
		//System.out.println("배열 사이즈 : "+ar.length);
		input_data(ar);
		// 합 구하기
		hap = calc_sum(ar);
		// 최대값, 최소값
		int max = ar[0];
		int min = ar[0];
		max = calc_max(ar);
		min = calc_min(ar);
		// 출력
		output(ar, hap, max, min);
	}
}
