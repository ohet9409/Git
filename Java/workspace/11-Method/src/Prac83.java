
import java.util.Scanner;

// 주민번호 7번째 자리를 입력받은 후 
public class Prac83 {
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호 7번째 자리를 입력하세요: ");
		int genNum = sc.nextInt();
		return genNum;
	}

	static int genYear(int genNum) {
		int year = 0;
		if (genNum == 1)
			year = 1900;
		else if (genNum == 2)
			year = 1900;
		else if (genNum == 3)
			year = 2000;
		else if (genNum == 4)
			year = 2000;
		else
			year = 0;
		return year;
	}

	static String gender(int genNum) {
		String gender = null;
		if (genNum == 1)
			gender = "남성";
		else if (genNum == 2)
			gender = "여성";
		else if (genNum == 3)
			gender = "남성";
		else if (genNum == 4)
			gender = "여성";
		else
			gender = null;
		;
		return gender;
	}

	static void output(int year, String gender) {
		if (gender != null)
			System.out.println("당신은 " + year + "년대생 " + gender+ "입니다");
		else
			System.out.println("잘못입력하셨습니다");
	}

	public static void main(String[] args) {
		// 선언: 변수 만들기
		int genNum = 0;
		int year = 0;
		String gender = null;
		// 입력: 변수에 데이터 저장하기
		genNum = input();
		// 연산: 저장된 데이터 가공하기
		year = genYear(genNum);
		gender = gender(genNum);
		// 출력: 결과값 확인하기
		output(year, gender);

	}

}
