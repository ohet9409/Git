import java.util.Scanner;

class AAA{
	// ����  --> ���� ����
	 Scanner sc = new Scanner(System.in);
	 int a, b, c;

	// �Է�
	 void input() {
		System.out.print("���� �Է� : ");
		a = sc.nextInt();
		System.out.print("���� �Է� : ");
		b = sc.nextInt();
	}

	// ����
	 void plus() {
		c = a + b;
	}

	// ���
	 void output() {

		System.out.println(c);

	}
	}
	public class Test {
	public static void main(String[] args) {
		// �ڵ� �ϼ� ����Ű: ctrl + space
		AAA aa;			// ���۷��� ����, ��ü
		aa = new AAA();	// new => 1. ���� ����� + �Լ� �����	2. ������� ������ �ּҸ� ������
		aa.input();
		aa.plus();
		aa.output();
		// . => ���� ������
	}

}
