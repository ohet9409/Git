
public class Exam4 {

	public static void main(String[] args) {
		// ���ڿ��� �Ϲ� �����ͷ� �ٲٱ�
		int num1 = Integer.parseInt("123");
		double num2 = Double.parseDouble("3.14");
		boolean bb = Boolean.parseBoolean("true");
		System.out.println("num1 : " +num1);
		System.out.println("num2 : " +num2);
		System.out.println("bb : " +bb);
		// �Ϲ� �����͸� ���ڿ��� �ٲٱ�
		String str1 = String.valueOf(123);
		String str2 = String.valueOf(1.23);
		String str3 = String.valueOf(false);
		String str4 = "" + 123;
		System.out.println("str1 : " +str1);
		System.out.println("str2 : " +str2);
		System.out.println("str3 : " +str3);
		System.out.println("str4 : " +str4);
	}

}
