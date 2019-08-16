import java.util.Scanner;
/** if를 이용해서 아래와 같이, 대문자는 소문자로 소문자는 대문자로 결과가 나오도록 작성하세요 */
public class Prac84 {
	static char input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char ch = sc.next().charAt(0);
		return ch;
	}
	static char changeChar(char ch){
		if(ch>='A' && ch<='Z')
			return (char) (ch+32);
		else if(ch>='a' && ch<='z')
			return (char)(ch-32);
		else
			return 0;
		
	}
	static void output(char ch, char result){
		if(result != 0)
		System.out.println(ch + " -> "+ result);
		else
			System.out.println("잘못 입력하셨습니다");
	}
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		char ch, result;
		// 입력
		ch= input();
		// 연산
		result = changeChar(ch);
		// 출력
		output(ch,result);
	}
}
