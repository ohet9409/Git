import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num1 = 0, num2 = 0, num3 = 0;
		char ch = 0;
		System.out.print("첫 번째 수: ");
		num1 = sc.nextFloat();
		System.out.print("두 번째 수: ");
		num2 = sc.nextFloat();
		System.out.print("연산자: ");
		ch = sc.next().charAt(0);
		switch (ch) {
		case '*':
			num3 = num1 * num2;
			break;
		case '+':
			num3 = num1 + num2;
			break;
		case '-':
			num3 = num1 - num2;
			break;
		case '/':
			num3 = num1 / num2;
			break;
		default: ch ='e'; // 'e'= 에러의 약자
		}
		if(ch!='e') {
		System.out.println(num1 + " " + ch + " " + num2 + " = " + num3);
		}else {
			System.out.println("연산자를 잘못 입력하셨습니다");
		}
}
}
