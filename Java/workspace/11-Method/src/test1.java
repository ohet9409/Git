import java.util.Scanner;

public class test1 {
	static int input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		return num;
	}
	static int plus(int a, int b){
		return a + b;
	}
	static void output(int a, int b,int c){
		System.out.println(a + " + " + b + " = " + c);
		//return;
	}
	public static void main(String[] args) {
		// ����
		int a=0, b=0, c=0;
		// �Է�
		a = input();
		b = input();
		// ����
		c = plus(a,b);
		// ���	
		output(a,b,c);
	}

//	public static void main(String[] args) {
//		// ���� : ���� �����
//		Scanner sc = new Scanner(System.in);
//		int a,b,c;
//		// �Է� : ������ ������ �����ϱ� (�⺻ ������ ����)
//		System.out.println("���� �Է� : ");
//		a = sc.nextInt();
//		System.out.println("���� �Է� : ");
//		b = sc.nextInt();
//		// ���� : ����� ������ �����ϱ�(����� �����͸� �����ؼ� ���� ���ϴ� ����� �����)
//		c = a + b;
//		// ��� : ����� Ȯ���ϱ�(���� ���ϴ� ����� ���Դ��� Ȯ��)
//		System.out.println(c);
//	}
}
