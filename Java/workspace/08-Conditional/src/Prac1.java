import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float num1 = 0, num2 = 0, num3 = 0;
		char ch = 0;
		System.out.print("ù ��° ��: ");
		num1 = sc.nextFloat();
		System.out.print("�� ��° ��: ");
		num2 = sc.nextFloat();
		System.out.print("������: ");
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
		default: ch ='e'; // 'e'= ������ ����
		}
		if(ch!='e') {
		System.out.println(num1 + " " + ch + " " + num2 + " = " + num3);
		}else {
			System.out.println("�����ڸ� �߸� �Է��ϼ̽��ϴ�");
		}
}
}
