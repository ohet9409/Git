package test;

import java.util.Scanner;

// ��ü �迭
public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		Controller controller = new Controller();
		
		while (true) {
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. ����");
			System.out.println("-------");
			System.out.print("��ȣ �Է� : ");
			num = sc.nextInt();

			switch (num) {
			case 1:
				controller.input();
				break;
			case 2:
				controller.output();
				break;
			case 3:
				System.out.println("���α׷� ����");
				System.exit(0);

			}
			System.out.println();
		}
	}
}
