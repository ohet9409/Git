import java.util.Scanner;

public class Prac2 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int mon = 0;
		int day = 0;
		int num = 0;
		int y = 0;
		int[] year = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		// 입력: 변수에 데이터 저장하기
		System.out.println("**** 일수 구하기 ****");
		System.out.print("년: ");
		y = sc.nextInt();
		System.out.print("월: ");
		mon = sc.nextInt();
		System.out.print("일: ");
		day = sc.nextInt();
		// 연산: 저장된 데이터 가공하기
		// 올해가 윤년인지 판단
		if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) {
			year[2] += 1;	// 2월에 일수를 1일 추가한다.
		}
		// month에 5가 저장된 경우: 1~4월 까지 합 구하기
		for (int x = 0; x < mon; x++) {
			num += year[x];
		}
		// 출력: 결과값 확인하기
		System.out.printf("1월1일부터 %d월%d일까지는 %d일 입니다.", mon, day, num + day);

	}
}
