import java.util.Scanner;

public class Exam8 {

	public static void main(String[] args) {
		/** �Է°��߿��� ū ���� ����ϱ� */
		// ����
		Scanner sc = new Scanner(System.in);
		int num1 =0, num2 = 0, result = 0;
		// �Է�
		System.out.print("���� �Է�: ");
		num1 = sc.nextInt();
		System.out.print("���� �Է�: ");
		num2= sc.nextInt();
		// ����
		result = (num1>num2)?num1:num2;
		//			����             true : false
		// ���
		System.out.println("ū ��: "+ result);
		

	}

}
