import java.util.Scanner;

public class Prac6 {
	static String inputName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ǰ���� �Է��Ͻÿ�: ");
		String name = sc.next();
		return name;
	}

	static int inputnum(String name) {
		Scanner sc = new Scanner(System.in);
		System.out.print(name +"�� �Է��Ͻÿ�: ");
		int amount = sc.nextInt();
		return amount;
	}

	static int compute(int qty, int price) {
		return qty * price;
	}

	static void output(String name, int money) {
		System.out.println();
		System.out.println("ǰ�� : " + name);
		System.out.println("�Ѿ� : " + money + "��");
	}

	public static void main(String[] args) {
		String name = null;
		int qty = 0, price = 0, money = 0;
		; // �ʿ��� ���� �����
		name = inputName();
		qty = inputnum("����");
		price = inputnum("�ܰ�"); 	// input()�Լ����� ȣ���Ͽ�, ǰ��, ����, �ܰ��� �Է� �����ÿ�
		money = compute(qty, price);	// compute()�Լ��� ȣ���Ͽ� ������� �޾Ƽ�, �Ѿ��� �����Ͻÿ�
		output(name, money);	// output()�Լ��� ȣ���Ͽ� ����� �Ʒ��� ���� ����Ͻÿ�
	}
}
