import java.util.Scanner;

public class Prac8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mid=0, fin=0, chul=0,avg=0, total=0;
		double home=0;
		char hak=0;
		System.out.print("�߰���縦 �Է��Ͻÿ�: ");
		mid=sc.nextDouble();
		System.out.print("�⸻��縦 �Է��Ͻÿ�: ");
		fin=sc.nextDouble();
		System.out.print("���������� �Է��Ͻÿ�: ");
		home=sc.nextDouble();
		System.out.print("�⼮������ �Է��Ͻÿ�: ");
		chul=sc.nextDouble();
		
		avg = (mid+fin)/2;
		total= (avg*0.6)+(home*0.2)+(chul*0.2);
		System.out.println();
		System.out.printf("����: %.2f\n",total); //�Ҽ��� 2° �ڸ�
		switch((int)total/10) { // �Ұ�ȣ �ȿ� ����, ����, ���ڿ��� ����
		case 10:
		case 9 : System.out.println("����-A"); hak='A'; break;
		case 8 : System.out.println("����-B"); hak='B'; break;
		case 7 : System.out.println("����-C"); hak='C'; break;
		case 6 : System.out.println("����-D"); hak='D'; break;
		default : System.out.println("����-F"); hak='F'; break;
		}
		switch (hak) {
		case 'A':
		case 'B': System.out.println("��-excellent"); break;
		case 'C':
		case 'D': System.out.println("�� -good"); break;
		case 'F':  System.out.println("��-poor"); break;
		}
		
	}

}
