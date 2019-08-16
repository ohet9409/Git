import java.util.Scanner;

class Calculator{
	// 선언
	Scanner sc = new Scanner(System.in);
	double num1, num2, result;
	char ch;
	// 입력
	void input() {
		System.out.print("첫 번째 수 : ");
		num1=sc.nextDouble();
		System.out.print("두 번째 수 : ");
		num2=sc.nextDouble();
		System.out.print("연산자 : ");
		ch = sc.next().charAt(0);
	}
	// 연산
	void calc() {
		switch (ch) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2; break;
		default: ch ='e';
		}
	}
	// 출력
	void output() {
		if(ch != 'e')
		System.out.printf(num1 + " " + ch + " " + num2 + " = " + result);
		else
			System.out.println("잘못입력하셨습니다");
	}
}
public class Prac81 {
	public static void main(String[] args) {
		Calculator a = new Calculator();
		a.input();
		a.calc();
		a.output();
	}
}
