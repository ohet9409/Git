
public class Prac4 {
	public static void main(String[] args) {
		//�Է�
		int a = 0;
		double b = 0.0;
		char c = ' ';
		boolean d = true;
		String e = null;
		//����
		a = 50;
		b = 178.5;
		c = 'A';
		e = "ȫ�浿";
		//����
		//���
		System.out.printf("���� a = " + a + "\n");
		System.out.printf("�Ǽ� b = " + b + "\n");
		System.out.printf("���� c = " + c + "\n");
		System.out.printf("boolean d = " + d + "\n");
		System.out.printf("���ڿ� e = " + e);
		System.out.println();
		System.out.println();
		System.out.printf("���� a = %d\n", a);	// %d = int
		System.out.printf("�Ǽ� b = %f\n", b);	// %f = double, float
		System.out.printf("���� c = %c\n", c);
		System.out.printf("boolean d= %b\n ", d);
		System.out.printf("���ڿ� e = %s\n", e);	// %s = String
		
		System.out.printf("���� c �ƽ�Ű �ڵ尪  = %d\n", (int)c);	// ���ڸ� int������ ��ȯ
	}
}
