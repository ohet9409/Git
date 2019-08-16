import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int jumsu=0;
		System.out.print("점수를 입력: ");
		jumsu = sc.nextInt();
		if(jumsu>=90) System.out.println("A학점");
		else if(jumsu>=80) System.out.println("B학점");
		else if(jumsu>=70) System.out.println("C학점");
		else if(jumsu>=60) System.out.println("D학점");
		else System.out.println("F학점");
	}
}
