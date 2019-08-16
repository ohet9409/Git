
import java.util.Scanner;

public class Prac81 {
	static double input_num(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + " 번째 수 : ");
		double num1 = sc.nextDouble();
		return num1;
	}

	static char input_op() {
		Scanner sc = new Scanner(System.in);
		System.out.print("연산자: ");
		char op = sc.next().charAt(0);
		switch (op) {
		case '+':
			return op;
		case '/':
			return op;
		case '*':
			return op;
		case '-':
			return op;
		default:
			return 'e';
		}
	}

	static double calc(double num1, double num2, char op) {
		double result = 0;
		switch (op) {
		case '*':
			result = num1 * num2;
			break;
		case '+':
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '/':
			result = num1 / num2;
			break;
		}
		return result;
	}

	static void output(double num1, double num2, char op, double result) {
		if (op != 'e')
			System.out.println(num1 + " "+ op + " " + num2 + " = " + result );
			//System.out.printf("%.2f %c %.2f = %.2f\n", num1, op, num2, result);
		else
			System.out.println("연산자가 잘못 입력되었습니다");
	}

	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		double num1 = 0, num2 = 0, result = 0;
		char op = 0;
		// 입력
		num1 = input_num("첫");
		num2 = input_num("두");
		op = input_op();
		// 연산
		result = calc(num1, num2, op);
		// 출력
		output(num1, num2, op, result);
	}
}
