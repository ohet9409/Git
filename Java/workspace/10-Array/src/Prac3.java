import java.util.Scanner;

public class Prac3 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int st = 0;
		System.out.print("몇명의 학생들의 점수를 입력하시겠습니까: ");
		st = sc.nextInt();
		int[] jumsu = new int[st];
		int[] rank = new int[st];
		// 입력
		for (int i = 0; i < jumsu.length; i++) {
			System.out.print((i + 1) + "번 점수 입력: ");
			jumsu[i] = sc.nextInt(); // 점수 저장
			rank[i] = 1; // 등수 초기화
		}
		// 연산
		for (int i = 0; i < jumsu.length; i++) { // 기준
			for (int j = 0; j < jumsu.length; j++) { // 모든 점수
				if (jumsu[i] < jumsu[j]) {
					rank[i] += 1;
				}
			}
		}
		// 출력
		System.out.println();
		System.out.println("***결과***");
		for (int i = 0; i < jumsu.length; i++) {
			System.out.println(jumsu[i] + "점 : " + rank[i] + "등");
		}
	}
}
