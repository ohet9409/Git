import java.util.Scanner;

public class Prac6 {
	static String inputName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("품명을 입력하시오: ");
		String name = sc.next();
		return name;
	}

	static int inputnum(String name) {
		Scanner sc = new Scanner(System.in);
		System.out.print(name +"을 입력하시오: ");
		int amount = sc.nextInt();
		return amount;
	}

	static int compute(int qty, int price) {
		return qty * price;
	}

	static void output(String name, int money) {
		System.out.println();
		System.out.println("품명 : " + name);
		System.out.println("총액 : " + money + "원");
	}

	public static void main(String[] args) {
		String name = null;
		int qty = 0, price = 0, money = 0;
		; // 필요한 변수 만들기
		name = inputName();
		qty = inputnum("수량");
		price = inputnum("단가"); 	// input()함수들을 호출하여, 품명, 수량, 단가를 입력 받으시오
		money = compute(qty, price);	// compute()함수를 호출하여 결과값을 받아서, 총액을 저장하시오
		output(name, money);	// output()함수를 호출하여 결과를 아래와 같이 출력하시오
	}
}
