import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=0;
		System.out.print("���� �Է�: ");
		year = sc.nextInt();
		
		// if((4�� ����̸鼭 100�� ����� �ƴ� ��)||(400�� ����� ��)) {
		// if((4�ǹ��) && (100�� ����� �ƴ� ��) || (400�� ����� ��)) {
		
		if(((year%4==0) && (year%100!=0)) || (year%400 == 0)) {
			System.out.println(year+"���� �����Դϴ�.");
		}else {
			System.out.println(year+"���� ����Դϴ�");
		}
	}
}
