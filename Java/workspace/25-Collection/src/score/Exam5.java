package score;

import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Score score = new ScoreImpl();	// 부모 기준 상속 사용법
		int num = 0;
		
		while (true) {
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.학번검색");
			System.out.println("4.이름검색");
			System.out.println("5.총점 내림차순");
			System.out.println("6.학번 오름차순");
			System.out.println("7.종료");
			System.out.println("------------");
			System.out.print("번호 : ");
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
				System.out.println("프로그램 종료!!");
				System.exit(0);
			
			default:
				break;
			}
			System.out.println();
		}

	}

}
