
public class Prac1 {
	public static void main(String[] args) {
		int num1 = 256;
		double num2 = 126948.776;
		// ���Ĺ��� �ڸ��� ����: %5d -> 5�ڸ� ����Ȯ��
		// %5.2f -> 5�ڸ� ����Ȯ��, �Ҽ����ڸ��� 2�ڸ�
		System.out.println(num1);
		System.out.println(num2);
		System.out.printf("num1= %d\n", num1);
		System.out.printf("num2= %f\n", num2);
		System.out.printf("num1= %5d\n", num1);		// ���ڸ� 2�ڸ��� �������� ǥ���Ѵ�.
		System.out.printf("num2= %5.2f\n", num2);
		System.out.printf("num1= %05d\n", num1);	// ���� �Ҽ��� ���ڸ��� 0���� ǥ�õ�
		System.out.printf("num2= %08.5f\n", num2);	// ���� �Ҽ��� ���ڸ��� 0���� ǥ�õ� 
	}
}
