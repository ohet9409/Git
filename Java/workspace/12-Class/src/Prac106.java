import java.util.Scanner;

class Parking {
	// 선언
	Scanner sc = new Scanner(System.in);
	int num, position;
	boolean in;
	boolean[] space = new boolean[5];

	// 입력
	void input_num() {
		System.out.println("주차 관리 프로그램");
		System.out.println("************");
		System.out.println("1. 입차");
		System.out.println("2. 출차");
		System.out.println("3. 리스트");
		System.out.println("4. 종료");
		System.out.println("************");
		System.out.print("메뉴 : ");
		num = sc.nextInt();
	}

	// 연산
	// 출력
	void input_position() {
		
		do {			// 위치를 1~5까지만 받기위해 반복문 사용
		System.out.print("위치 입력 : ");
		position = sc.nextInt();
		}while(position <1 || position>6);
	}
	void input_car() {
		input_position();
		System.out.println(position + "위치에 입차/");
		if(space[position-1]) System.out.println("이미 주차되어있습니다");	// 해당 배열의 값이 true일 경우
		else {
			System.out.println("주차되었습니다");
			space[position-1] = true;
		}
	}
	void output_car(){
		input_position();
		System.out.println(position + "위치에 출차/");
		if(space[position-1]) {System.out.println("출차되었습니다"); space[position-1] = false;}
		else {
			System.out.println("주차되어 있지 않습니다");	
	}
	}
	void print_list() {
		for(int x = 0; x<space.length; x++) {
			System.out.println((x+1) + "위치 : " + space[x]);
		}
	}
	void endPgm() {
		System.out.println("프로그램을 종료합니다");
		System.exit(0);	// 프로그램 종료
	}
	void main() {
		while(true) {
			input_num();
			switch (num) {
			case 1: input_car(); 
				break;
			case 2: output_car(); 
			break;
			case 3: print_list();
			break;
			case 4: endPgm(); 
			break;
			}
			System.out.println();
		}
	}
		
}

public class Prac106 {
	
	public static void main(String[] args) {
		Parking parking = new Parking();
		parking.main();
	}
}
