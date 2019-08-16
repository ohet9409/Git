import java.util.Scanner;

public class test1 {
	static int input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		return num;
	}
	static int plus(int a, int b){
		return a + b;
	}
	static void output(int a, int b,int c){
		System.out.println(a + " + " + b + " = " + c);
		//return;
	}
	public static void main(String[] args) {
		// 선언
		int a=0, b=0, c=0;
		// 입력
		a = input();
		b = input();
		// 연산
		c = plus(a,b);
		// 출력	
		output(a,b,c);
	}

//	public static void main(String[] args) {
//		// 선언 : 변수 만들기
//		Scanner sc = new Scanner(System.in);
//		int a,b,c;
//		// 입력 : 변수에 데이터 저장하기 (기본 데이터 저장)
//		System.out.println("정수 입력 : ");
//		a = sc.nextInt();
//		System.out.println("정수 입력 : ");
//		b = sc.nextInt();
//		// 연산 : 저장된 데이터 가공하기(저장된 데이터를 가공해서 내가 원하는 결과를 만들기)
//		c = a + b;
//		// 출력 : 결과값 확인하기(내가 원하는 결과가 나왔는지 확인)
//		System.out.println(c);
//	}
}
