package chr;

import java.util.Scanner;

public class dow {

	public static void main(String[] args) {
		/*
		System.out.println("�޽����� �Է��ϼ���");
		System.out.println("���α׷��� �����Ϸ��� q�� �Է��ϼ���");
		Scanner sca = new Scanner(System.in);
		String in;
		
		int i=0;
		do {
			System.out.println(">");
			in=sca.nextLine();
			System.out.println(in);
			
		}while(! in.equals("q"));
		System.out.println();
		System.out.println("���α׷� ����");
	*/
		while(true) {
			int num = (int)(Math.random()*6)+1;
			System.out.println(num);
			if(num==6) {
				break;
			}
		}
		System.out.println("���α׷� ����");
}

}
