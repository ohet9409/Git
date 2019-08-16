
public class Exam1 {

	public static void main(String[] args) {
		// 문자열의 숫자 변환
		// 1. 정상적인 경우
		String year1 = "1994";
		int age1 = 2019 - Integer.parseInt(year1) +1;	// 문자열을 정수로 변환
		System.out.println(age1);
		// 2. 비정상적인 경우
		String year2 = "뭘까요?";
		int age2 = 2019- Integer.parseInt(year2)+1;
		System.out.println(age2);

	}

}
