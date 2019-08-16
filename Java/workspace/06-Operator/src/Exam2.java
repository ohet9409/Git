
public class Exam2 {
	public static void main(String[] args) {
		/* 정수의 나눗셈 */
		int a = 7;
		int b = 3;
		int result = a/b;
		System.out.printf("%d / %d= %d\n", a, b, result);
		/* 실수의 나눗셈 */
		double aa = 7;
		double bb = 3;
		double result2 = aa/bb;
		System.out.printf("%f / %f= %f\n", aa, bb, result2);
		/* 정수와 실수를 계산 */
		int aaa = 7;
		double bbb = 3;
		// int result3 = aaa/bbb;
		double result3 = aaa/bbb;
		System.out.printf("%d / %f= %f\n", aaa, bbb, result3);
		/* 나머지 계산: 반드시 정수만 사용할 것 */
		System.out.println("5.5 % 2.2 = "+ (5.5%2.2));
		/* 0으로 나누기: 정수는 0으로 나누면 안됨 */
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
