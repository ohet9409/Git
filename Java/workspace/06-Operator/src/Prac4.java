import java.util.Scanner;

public class Prac4 {
	// 소문자를 대문자로 / 대문자를 소문자로 변환
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		char ch=0, result=0;
		// 입력
		System.out.print("문자 입력: ");
		ch=sc.next().charAt(0);// 문자 한개 입력
		// 연산
		//          대문자인지 검사                                                            소문자 인지 검사
		result=(ch>='A' && ch<='Z')? (char)(ch+32) : (ch>='a' && ch<='z')? (char)(ch-32):0; 
		System.out.println((result != 0)?(ch + "->"+ result):"문자가 아닙니다");
		System.out.printf("%s -> %s", ch,result);

	}

}
