
import java.util.Scanner;

public class Prac91 {
	static int input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("1~100 사이의 배수를 구할 숫자 입력: ");
		int num = sc.nextInt();
		return num;
	}
	static int printNum(int num1){
		int count =0;
		for (int a = 1; a <= 100; a++) {
			if (a % num1 == 0) {
				System.out.print(a + " ");
				count++;
				if(count%10 == 0) {
					System.out.println();
				}
			}
		}
		return count;
	}
	static void output(int num1,int count){
		System.out.println();
		System.out.println("1~100 사이의 " + num1 + "의 배수 개수  = " + count);
	}
	public static void main(String[] args) {
		// 선언	
		int num1 = 0, count = 0;
		// 입력
		num1 = input();
		// 연산
		count = printNum(num1);
		// 출력
		output(num1,count);
	}
}
