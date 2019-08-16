
import java.util.Scanner;

class Gugudan9 {
	// 선언
	Scanner sc = new Scanner(System.in);
	int dan;
	char con;

	// 입력
	void input_dan() {
		System.out.print("몇 단을 출력할지 입력하시오 : ");
		dan = sc.nextInt();
	}

	void input_ch() {
		System.out.print("선택하시오(y:계속): ");
		con = sc.next().charAt(0);
	}
	// 연산
	// 출력

	void output() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}
	// 총관리
	void mainControl() {
		do {
			input_dan();
			output();
			input_ch();
			System.out.println();
		}while(con == 'y');
		System.out.println("종료합니다");
	}
}
public class Prac93_1 {
	public static void main(String[] args) {
		/** while을 사용하는 첫번째 방법 */
//		Gugudan9 gugudan = new Gugudan9();
//		gugudan.mainControl();
		
		/** while을 사용하는 두번째 방법*/
		Gugudan9 gugudan = new Gugudan9();
		do {
			gugudan.input_dan();
			gugudan.output();
			gugudan.input_ch();
		}while(gugudan.con == 'y');
		System.out.println("프로그램 종료");
	}
}
