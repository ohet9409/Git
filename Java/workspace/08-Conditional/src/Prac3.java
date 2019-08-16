import java.util.Scanner;

// 주민번호 7번째 자리를 입력받은 후 
public class Prac3 {

	public static void main(String[] args) {
		// 선언: 변수 만들기
		Scanner sc = new Scanner(System.in);
		int ju = 0;
		// 입력: 변수에 데이터 저장하기
		System.out.print("주민번호 7번째 자리를 입력하세요: ");
		ju = sc.nextInt();
		// 연산: 저장된 데이터 가공하기
		// 출력: 결과값 확인하기
		if (ju == 1)
			System.out.println("당신은 1900년대생 남성이십니다");
		else if (ju == 2)
			System.out.println("당신은 1900년대생 남성이십니다");
		else if (ju == 3)
			System.out.println("당신은 2000년대생 남성이십니다");
		else if (ju == 4)
			System.out.println("당신은 2000년대생 여성이십니다");
		else
			System.out.println("1 ~ 4사이의 숫자만 입력해 주세요");

	}

}
