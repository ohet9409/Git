import java.util.Scanner;

class Calculator{
	// ����
	Scanner sc = new Scanner(System.in);
	double num1, num2, result;
	char ch;
	// �Է�
	void input() {
		System.out.print("ù ��° �� : ");
		num1=sc.nextDouble();
		System.out.print("�� ��° �� : ");
		num2=sc.nextDouble();
		System.out.print("������ : ");
		ch = sc.next().charAt(0);
	}
	// ����
	void calc() {
		switch (ch) {
		case '+': result = num1 + num2; break;
		case '-': result = num1 - num2; break;
		case '*': result = num1 * num2; break;
		case '/': result = num1 / num2; break;
		default: ch ='e';
		}
	}
	// ���
	void output() {
		if(ch != 'e')
		System.out.printf(num1 + " " + ch + " " + num2 + " = " + result);
		else
			System.out.println("�߸��Է��ϼ̽��ϴ�");
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
