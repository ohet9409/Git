
import java.util.Scanner;

public class Prac91 {
	static int input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("1~100 ������ ����� ���� ���� �Է�: ");
		int num = sc.nextInt();
		return num;
	}
	static int printNum(int num1){
		int count =0;
		for (int a = 1; a <= 100; a++) {
			if (a % num1 == 0) {
				System.out.print(a + " ");
				count++;
				if(count%10 == 0) {
					System.out.println();
				}
			}
		}
		return count;
	}
	static void output(int num1,int count){
		System.out.println();
		System.out.println("1~100 ������ " + num1 + "�� ��� ����  = " + count);
	}
	public static void main(String[] args) {
		// ����	
		int num1 = 0, count = 0;
		// �Է�
		num1 = input();
		// ����
		count = printNum(num1);
		// ���
		output(num1,count);
	}
}
