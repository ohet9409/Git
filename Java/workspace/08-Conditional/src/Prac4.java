import java.util.Scanner;
/** if를 이용해서 아래와 같이, 대문자는 소문자로 소문자는 대문자로 결과가 나오도록 작성하세요 */
public class Prac4 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		char i;
		// 입력
		System.out.print("문자 입력: ");
		i=sc.next().charAt(0);
		// 연산
		// 출력
		if(i>='A' && i<='Z')
			System.out.println(i + " -> "+ (char)(i+32));
		else if(i>='a' && i<='z')
			System.out.println(i + " -> "+ (char)(i-32));
		else
			System.out.println("문자만 입력하세요");
	}
}
