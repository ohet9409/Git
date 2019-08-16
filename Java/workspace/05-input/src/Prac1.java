import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in); // 스캐너 사용 준비
		String name = null;
		int kor = 0;
		int en = 0;
		int mat = 0;
		int tot = 0;
		// 입력
		System.out.print("이름? ");
		name = sc.next();
		System.out.print("국어? ");
		en = sc.nextInt();
		System.out.print("영어? ");
		mat = sc.nextInt();
		System.out.print("수학? ");
		kor = sc.nextInt();
		// 연산
		tot = kor + en + mat;
		// 출력
		System.out.println("이름: " + name);
		System.out.print("총점: " + tot);

	}

}
