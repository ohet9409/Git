import java.util.Scanner;

public class Prac93 {
	static int inputDan(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�� ���� ����� �� �Է��Ͻÿ� : ");
		int dan = sc.nextInt();
		return dan;
	}
	static void printGugudan(int dan){
		for (int a = 1; a <= 9; a++) { // 1~9
			System.out.printf("%d * %d = %d\n", dan, a, dan * a);
		}
	}
	static void isContinue(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Ͻÿ�(y:���): ");
		char ch = sc.next().charAt(0);
		if (ch != 'y') {
			System.out.println("���α׷� ����");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// ����
		int dan = 0; // �� ����
		// �Է�
		while (true) {
			dan = inputDan();
			// ����
			// ���
			printGugudan(dan);
			isContinue();
			System.out.println();
		}
	}
}
