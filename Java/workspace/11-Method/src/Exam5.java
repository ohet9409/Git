import java.util.Scanner;

public class Exam5 {
	static void input(int[] p){				//주소가 같으므로 return 필요없음
		Scanner sc = new Scanner(System.in);
		for(int x=0; x<p.length;x++) {
			System.out.print((x+1) + "번째 숫자 입력 : ");
			p[x] = sc.nextInt();
		}
	}
	static void output(int[] p){
		System.out.println();
		System.out.println("*** 출력 ***");
		for(int x=0; x<p.length;x++) {
			System.out.print(p[x] + " ");
		}
	}
	public static void main(String[] args) {
		// 선언
		
		int[] n = new int[5];
		// 입력
		input(n);	//주소를 전달 
		// 출력
		output(n);
//		// 입력
//		for(int x = 0; x<n.length; x++) {
//			System.out.print((x+1) + "번째 숫자 입력 : ");
//			n[x] = sc.nextInt();
//		}
//		// 출력
//		for(int x = 0; x<n.length; x++) {
//			System.out.print(n[x] + " ");
//		}
//	
		}
}
