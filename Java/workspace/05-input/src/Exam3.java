import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in); //System.in: 키보드 입력
		String name;
		int kor;
		double height;
		char ch;
		// 입력
		System.out.print("이름: ");
		name = sc.next(); // 문자열 1개
		System.out.print("국어: ");
		kor = sc.nextInt(); // 정수 1개
		System.out.print("키: ");
		height = sc.nextDouble(); // 실수1개
		System.out.print("문자: ");
		ch = sc.next().charAt(0); // 문자1개: 키보드버퍼에 저장된 문자열로 읽어와서, 그 중에 문자 1개만 읽어옴 (0:첫번째 1:두번째)
		// 연산
		// 출력
		System.out.println(name + " : " + kor);
		System.out.println("키: " + height);
		System.out.println("문자: " + ch);
	}
}
