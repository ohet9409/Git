import java.util.Scanner;

// a= �߰�  b= �⸻  c= ��������  d= �⼮����  i= ����  avg= ���  hak = ����
public class Prac7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c, d;
		double i;
		double avg;
		char hak = 0;
		System.out.print("�߰���縦 �Է��Ͻÿ�: ");
		a = sc.nextInt();
		System.out.print("�⸻��縦 �Է��Ͻÿ�: ");
		b = sc.nextInt();
		System.out.print("���������� �Է��Ͻÿ�: ");
		c = sc.nextInt();
		System.out.print("�⼮������ �Է��Ͻÿ�: ");
		d = sc.nextInt();
		avg = (a + b) / 2;
		i = (double) ((avg * 0.6) + (c * 0.2) + (d * 0.2));
		System.out.println();
		System.out.printf("����= %.2f\n", i);
		if (i >= 90) {
			hak = 'A';
			System.out.println("����-A");
		} else if (i >= 80) {
			hak = 'B';
			System.out.println("����-B");
		} else if (i >= 70) {
			hak = 'C';
			System.out.println("����-C");
		} else if (i >= 60) {
			hak = 'D';
			System.out.println("����-D");
		} else {
			hak = 'F';
			System.out.println("����-F");
		}
		if ((hak == 'A') || (hak == 'B')) {
			System.out.println("��=excellent");
		} else if ((hak == 'C') || (hak == 'D')) {
			System.out.println("��=good");
		} else
			System.out.println("��=poor");
	}
}
