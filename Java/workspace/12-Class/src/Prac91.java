import java.util.Scanner;

class Multiple{
	// ����
	Scanner sc = new Scanner(System.in);
	int num, count;
	// �Է�
	void input() {
		System.out.print("1~100 ������ ����� ���� ���� �Է� : ");
		num = sc.nextInt();
	}
	// ����
	void calc() {
		for(int i=1; i<=100; i++) {
			if(i%num == 0) {
				System.out.print(i+ " ");
				count++;
			}
		}
		System.out.println();
	}
	// ���
	void output() {
		System.out.printf("1~100 ������ %d�� ��� ���� = %d\n", num, count);
	}
}
public class Prac91 {
	public static void main(String[] args) {
		Multiple num = new Multiple();
		num.input();
		num.calc();
		num.output();
	}
}
