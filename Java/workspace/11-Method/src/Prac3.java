import java.util.Scanner;

public class Prac3 {
	static int square(int s1){
		return s1*s1;
	}
	static double square(double s2){
		return s2*s2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s1;
		double s2;
		
		System.out.print("���� �Է�: ");
		s1 = sc.nextInt();
		System.out.print("�Ǽ� �Է�: ");
		s2 = sc.nextDouble();
		
		System.out.println("���� ���� : " + square(s1));
		System.out.println("�Ǽ� ���� : " + square(s2));
	}
}
