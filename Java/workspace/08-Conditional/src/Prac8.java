import java.util.Scanner;

public class Prac8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double mid=0, fin=0, chul=0,avg=0, total=0;
		double home=0;
		char hak=0;
		System.out.print("중간고사를 입력하시오: ");
		mid=sc.nextDouble();
		System.out.print("기말고사를 입력하시오: ");
		fin=sc.nextDouble();
		System.out.print("과제점수를 입력하시오: ");
		home=sc.nextDouble();
		System.out.print("출석점수를 입력하시오: ");
		chul=sc.nextDouble();
		
		avg = (mid+fin)/2;
		total= (avg*0.6)+(home*0.2)+(chul*0.2);
		System.out.println();
		System.out.printf("성적: %.2f\n",total); //소수점 2째 자리
		switch((int)total/10) { // 소괄호 안에 정수, 문자, 문자열만 가능
		case 10:
		case 9 : System.out.println("학점-A"); hak='A'; break;
		case 8 : System.out.println("학점-B"); hak='B'; break;
		case 7 : System.out.println("학점-C"); hak='C'; break;
		case 6 : System.out.println("학점-D"); hak='D'; break;
		default : System.out.println("학점-F"); hak='F'; break;
		}
		switch (hak) {
		case 'A':
		case 'B': System.out.println("평가-excellent"); break;
		case 'C':
		case 'D': System.out.println("평가 -good"); break;
		case 'F':  System.out.println("평가-poor"); break;
		}
		
	}

}
