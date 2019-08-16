import java.util.Scanner;

class Multiple{
	// 선언
	Scanner sc = new Scanner(System.in);
	int num, count;
	// 입력
	void input() {
		System.out.print("1~100 사이의 배수를 구할 숫자 입력 : ");
		num = sc.nextInt();
	}
	// 연산
	void calc() {
		for(int i=1; i<=100; i++) {
			if(i%num == 0) {
				System.out.print(i+ " ");
				count++;
			}
		}
		System.out.println();
	}
	// 출력
	void output() {
		System.out.printf("1~100 사이의 %d의 배수 개수 = %d\n", num, count);
	}
}
public class Prac91 {
	public static void main(String[] args) {
		Multiple num = new Multiple();
		num.input();
		num.calc();
		num.output();
	}
}
