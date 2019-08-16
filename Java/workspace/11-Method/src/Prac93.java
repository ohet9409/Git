import java.util.Scanner;

public class Prac93 {
	static int inputDan(){
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 단을 출력할 지 입력하시오 : ");
		int dan = sc.nextInt();
		return dan;
	}
	static void printGugudan(int dan){
		for (int a = 1; a <= 9; a++) { // 1~9
			System.out.printf("%d * %d = %d\n", dan, a, dan * a);
		}
	}
	static void isContinue(){
		Scanner sc = new Scanner(System.in);
		System.out.print("선택하시오(y:계속): ");
		char ch = sc.next().charAt(0);
		if (ch != 'y') {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// 선언
		int dan = 0; // 단 저장
		// 입력
		while (true) {
			dan = inputDan();
			// 연산
			// 출력
			printGugudan(dan);
			isContinue();
			System.out.println();
		}
	}
}
