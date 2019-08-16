import java.util.Scanner;

public class Exam2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=0;
		System.out.print("연도 입력: ");
		year = sc.nextInt();
		
		// if((4의 배수이면서 100의 배수가 아닐 때)||(400의 배수일 때)) {
		// if((4의배수) && (100의 배수가 아닐 때) || (400의 배수일 때)) {
		
		if(((year%4==0) && (year%100!=0)) || (year%400 == 0)) {
			System.out.println(year+"년은 윤년입니다.");
		}else {
			System.out.println(year+"년은 평년입니다");
		}
	}
}
