package score;

import java.util.List;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Score score = new ScoreImpl();	// �θ� ���� ��� ����
		int num = 0;
		
		while (true) {
			System.out.println("1.�Է�");
			System.out.println("2.���");
			System.out.println("3.�й��˻�");
			System.out.println("4.�̸��˻�");
			System.out.println("5.���� ��������");
			System.out.println("6.�й� ��������");
			System.out.println("7.���� ����");
			System.out.println("8.���� �б�");
			System.out.println("9.����");
			System.out.println("------------");
			System.out.print("��ȣ : ");
			num = sc.nextInt();
			
			System.out.println();
			switch (num) {
			case 1:
				score.input();
				break;
			case 2:
				score.print();
				break;
			case 3:
				score.searchHak();
				
				break;
			case 4:
				score.searchName();
				break;
			case 5:
				score.descSortTot();
				break;
			case 6:
				score.ascSortHak();
				break;
			case 7:
				
				score.writeFile();
				break;
			case 8:
				score.readFile();
				
				break;
			case 9:
				score.pgmEnd();
				break;
			default:
				break;
			}
			System.out.println();
		}

	}

}
