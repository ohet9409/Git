import java.util.Scanner;

class Gugudan {
	// 선언
	Scanner sc = new Scanner(System.in);
	int dan;
	char con;

	// 입력
	void input() {
		System.out.print("몇 단을 출력할지 입력하시오 : ");
		dan = sc.nextInt(); 
	}

	// 연산
	void calc() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}

	// 출력
	void output() {
		System.out.print("선택하시오(y:계속): ");
		con = sc.next().charAt(0);
		if(con != 'y')
			System.out.println("종료합니다");
	}
}

public class Prac93 {
	public static void main(String[] args) {
		Gugudan gugudan = new Gugudan();
		do {
		gugudan.input();
		gugudan.calc();
		gugudan.output();
		}while(gugudan.con == 'y');
	}
}
