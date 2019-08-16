package chr;

import java.util.Scanner;

public class dow {

	public static void main(String[] args) {
		/*
		System.out.println("메시지를 입력하세요");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");
		Scanner sca = new Scanner(System.in);
		String in;
		
		int i=0;
		do {
			System.out.println(">");
			in=sca.nextLine();
			System.out.println(in);
			
		}while(! in.equals("q"));
		System.out.println();
		System.out.println("프로그램 종료");
	*/
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if(num==6) {
				break;
			}
		}
		System.out.println("프로그램 종료");
}

}
