package prac1;

import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape shape =null;
		int num;
		while(true) {
			
		System.out.println("1.�簢��\t2.��\t3.����");
		System.out.print("select(1~3) : ");
		num = sc.nextInt();
		// ���� ���ε� : �����߿� ���۵Ǿ��� Ŭ������ ����� ��
		switch (num) {
		case 1:
			shape = new Rectangle();
			shape.onDraw();
			shape.onDelete();
			System.out.println();
			break;
		case 2:
			shape = new Circle();
			shape.onDraw();
			shape.onDelete();
			System.out.println();
			break;
			
		case 3:
			System.out.println("�����մϴ�");
			System.exit(0);
		default:
			System.out.println("�߸� �Է��߽��ϴ�");
			System.out.println();
			break;
		}
		}
	}
}
