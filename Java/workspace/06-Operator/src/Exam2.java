
public class Exam2 {
	public static void main(String[] args) {
		/* ������ ������ */
		int a = 7;
		int b = 3;
		int result = a/b;
		System.out.printf("%d / %d= %d\n", a, b, result);
		/* �Ǽ��� ������ */
		double aa = 7;
		double bb = 3;
		double result2 = aa/bb;
		System.out.printf("%f / %f= %f\n", aa, bb, result2);
		/* ������ �Ǽ��� ��� */
		int aaa = 7;
		double bbb = 3;
		// int result3 = aaa/bbb;
		double result3 = aaa/bbb;
		System.out.printf("%d / %f= %f\n", aaa, bbb, result3);
		/* ������ ���: �ݵ�� ������ ����� �� */
		System.out.println("5.5 % 2.2 = "+ (5.5%2.2));
		/* 0���� ������: ������ 0���� ������ �ȵ� */
		a=7;
		b=1;
		result=a/b;
		System.out.printf("%d / %d = %d\n",a,b,result);
		aa=7;
		bb=0;
		result2=aa/bb;
		System.out.printf("%f / %f = %f\n",a,b,result);
	}
}
