import java.util.Scanner;

public class Prac {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, temp;
		System.out.print("�����Է�(1): ");
		a = sc.nextInt();
		System.out.print("�����Է�(2): ");
		b = sc.nextInt();
		System.out.print("�����Է�(3): ");
		c = sc.nextInt();
		
//		if (a < b) {
//			if (a < c) {
//				if (b < c) {
//					System.out.printf("%d %d %d",a , b , c);
//				} else if(c<b){
//					System.out.printf("%d %d %d",a , c , b);
//				}else if(a < b) {
//					System.out.printf("%d %d %d",c , a , b);
//			}}}
//		else if (b < c) {
//			if (c <a) {
//				System.out.printf("%d %d %d",b , c ,a);
//			}else {
//				System.out.printf("%d %d %d",b , a , c);
//			}
//			}else if(b<a) {
//				System.out.printf("%d %d %d",c , b , a);
//			}
//	}
//}

		// ����
		// �������� �˰��� ���
		// ù��°���� �ι�° �� ��
		if(a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		// ù��°���� ����° �� ��
		if(a > c) {
			temp = a;
			a = c;
			c = temp;
		}
		// �ι�°���� ����° �� ��
		if(b > c) {
			temp = b;
			b = c;
			c = temp;
		}
		//���
		System.out.println(a+" "+ b+" "+ c);
		}
	}
		
		

