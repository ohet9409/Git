import java.util.Scanner;
public class Practice2 {
	// 지폐 나누기
	public static void main(String[] args) {
		// 선언: 변수 만들기
		Scanner sc = new Scanner(System.in);
		int money = 0;// 금액
		int oman = 0; // 오만원
		int man = 0; // 만원
		int chun = 0;// 천원
		int baek = 0;// 백원
		int ten = 0;// 십원
		int one = 0;// 일원
		int namugy = 0;// 나머지
		// 입력: 변수에 데이터 저장하기
		System.out.print("금액 입력: ");
		money = sc.nextInt();
		// 연산: 저장된 데이터 가공하기
		oman = money / 50000; // 몫 저장 76543원
		namugy = money % 50000;// 나머지 26543원
		man = namugy / 10000; // 몫 저장 2
		namugy = namugy % 10000;// 나머지 6543
		chun = namugy / 1000; // 몫 저장
		namugy = namugy % 1000;// 나머지 543
		baek = namugy / 100; // 몫 저장
		namugy = namugy % 100;// 나머지 43
		ten = namugy / 10; // 몫 저장
		one = namugy % 10; // 나머지 3
		// 출력: 결과값 확인하기

		System.out.println("금액: " + money + "원");
		if (oman != 0)
			System.out.println("5만원: " + oman + "장");
		if (man != 0)
			System.out.println("만원: " + man + "장");
		if (chun != 0)
			System.out.println("천원: " + chun + "장");
		if (baek != 0)
			System.out.println("백원: " + baek + "개");
		if (ten != 0)
			System.out.println("십원: " + ten + "개");
		if (one != 0)
			System.out.println("일원: " + one + "개");
	}
}
