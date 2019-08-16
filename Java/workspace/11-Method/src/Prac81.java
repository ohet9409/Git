
import java.util.Scanner;

public class Prac81 {
	static double input_num(String str) {
		Scanner sc = new Scanner(System.in);
		System.out.print(str + " ��° �� : ");
		double num1 = sc.nextDouble();
		return num1;
	}

	static char input_op() {
		Scanner sc = new Scanner(System.in);
		System.out.print("������: ");
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
			System.out.println("�����ڰ� �߸� �ԷµǾ����ϴ�");
	}

	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		double num1 = 0, num2 = 0, result = 0;
		char op = 0;
		// �Է�
		num1 = input_num("ù");
		num2 = input_num("��");
		op = input_op();
		// ����
		result = calc(num1, num2, op);
		// ���
		output(num1, num2, op, result);
	}
}
