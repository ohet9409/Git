import java.util.Scanner;

public class Exam5 {
	static void input(int[] p){				//�ּҰ� �����Ƿ� return �ʿ����
		Scanner sc = new Scanner(System.in);
		for(int x=0; x<p.length;x++) {
			System.out.print((x+1) + "��° ���� �Է� : ");
			p[x] = sc.nextInt();
		}
	}
	static void output(int[] p){
		System.out.println();
		System.out.println("*** ��� ***");
		for(int x=0; x<p.length;x++) {
			System.out.print(p[x] + " ");
		}
	}
	public static void main(String[] args) {
		// ����
		
		int[] n = new int[5];
		// �Է�
		input(n);	//�ּҸ� ���� 
		// ���
		output(n);
//		// �Է�
//		for(int x = 0; x<n.length; x++) {
//			System.out.print((x+1) + "��° ���� �Է� : ");
//			n[x] = sc.nextInt();
//		}
//		// ���
//		for(int x = 0; x<n.length; x++) {
//			System.out.print(n[x] + " ");
//		}
//	
		}
}
