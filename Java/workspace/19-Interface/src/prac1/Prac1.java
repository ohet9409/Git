package prac1;

import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Shape shape =null;
		int num;
		while(true) {
			
		System.out.println("1.사각형\t2.원\t3.종료");
		System.out.print("select(1~3) : ");
		num = sc.nextInt();
		// 동적 바인딩 : 실행중에 동작되어질 클래스를 만드는 것
		switch (num) {
		case 1:
			shape = new Rectangle();
			shape.onDraw();
			shape.onDelete();
			System.out.println();
			break;
		case 2:
			shape = new Circle();
			shape.onDraw();
			shape.onDelete();
			System.out.println();
			break;
			
		case 3:
			System.out.println("종료합니다");
			System.exit(0);
		default:
			System.out.println("잘못 입력했습니다");
			System.out.println();
			break;
		}
		}
	}
}
