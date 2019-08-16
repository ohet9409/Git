import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1=0;
		int num2=0;
		System.out.print("첫번째 수: ");
		num1 = sc.nextInt();
		System.out.print("두번째 수: ");
		num2 = sc.nextInt();
		System.out.printf("첫번째 수(%d)가 두번째 수(%d)보다  %s 입니다.",num1,num2,(num1>num2)?"큰 수": "작은 수");

	}

}
