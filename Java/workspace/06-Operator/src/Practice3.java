import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1=0;
		int num2=0;
		System.out.print("ù��° ��: ");
		num1 = sc.nextInt();
		System.out.print("�ι�° ��: ");
		num2 = sc.nextInt();
		System.out.printf("ù��° ��(%d)�� �ι�° ��(%d)����  %s �Դϴ�.",num1,num2,(num1>num2)?"ū ��": "���� ��");

	}

}
