
public class Exam4 {
	public static void main(String[] args) {
		// 변수값 1증가 시키기
		int num1 =1;
		System.out.println("num1= "+ num1);
		
		num1 = num1 + 1; // 2
		System.out.println("num1= "+ num1);
		
		num1 += 1; // 3
		System.out.println("num1= "+ num1);
		
		num1 ++; // ++: 증가 연산자  ==> 변수값 1증가 시키기  // 4
		System.out.println("num1= "+ num1);
		
		++ num1;
		System.out.println("num1= "+ num1);
		
		// 변수값 1감소 시키기
		num1 = num1 -1; // 4
		System.out.println("num1= "+ num1);
		
		num1 -= 1; // 3
		System.out.println("num1= "+ num1);
		
		num1 --; // --: 감소 연산자 ==> 변수값 1감소 시키기 // 2 
		System.out.println("num1= "+ num1);
		
		--num1; // 1
		System.out.println("num1= "+ num1);
	}
}
