import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		// ���� ������: ���� ���� ������ ���� ���踦 ������, ���� ���̸� true, ���� �����̸� false
		Scanner sc = new Scanner(System.in);
		int num1 =0, num2=0;
		System.out.print("���� �Է�: ");
		num1 = sc.nextInt();
		System.out.print("���� �Է�: ");
		num2 = sc.nextInt();
		
		//���� ������ ����� boolean ���̴�
		boolean result1 = num1 > num2;
		boolean result2 = num1 < num2;
		boolean result3 = num1 >= num2;
		boolean result4 = num1 <= num2;
		boolean result5 = num1 == num2; // ������ �˻� -> ������ true, �ٸ��� false
		boolean result6 = num1 != num2; // �ٸ��� �˻� -> �ٸ��� true, ������ false
//		 �ּ�ó�� ����Ű : ctrl +/
		System.out.println("result1 = " + result1);
		System.out.println("result2 = " + result2);
		System.out.println("result3 = " + result3);
		System.out.println("result4 = " + result4);
		System.out.println("result5 = " + result5);
		System.out.println("result6 = " + result6);
		
	}
}
