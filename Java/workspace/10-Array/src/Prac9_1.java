import java.util.Scanner;

public class Prac9_1 {
	public static void main(String[] args) {
		// 선언: 변수 만들기
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3]; // 이름
		int[][] jumsu = new int[3][3]; // 국어, 영어, 수학
		int[] tot = new int[3]; // 총점
		double[] avg = new double[3]; // 평균
		char[] grade = new char[3]; // 학점
		// 입력: 변수에 데이터 저장하기
		for (int x = 0; x < name.length; x++) {
			System.out.print("이름: ");
			name[x] = sc.next();
			System.out.print("국어: ");
			jumsu[x][0] = sc.nextInt();
			System.out.print("영어: ");
			jumsu[x][1] = sc.nextInt();
			System.out.print("수학: ");
			jumsu[x][2] = sc.nextInt();
		}
		// 연산: 저장된 데이터 가공하기
		for(int x=0; x<name.length; x++) {
			// 총점
			tot[x] = jumsu[x][0] + jumsu[x][1] + jumsu[x][2];
			// 평균
			avg[x] = (double)tot[x]/jumsu.length;
			// 학점
			switch((int)avg[x]/10) {
			case 10:
			case 9: grade[x] ='A'; break;
			case 8: grade[x] ='B'; break;
			case 7: grade[x] ='C'; break;
			case 6: grade[x] ='D'; break;
			default: grade[x] ='F'; break;		
			}
		}
		
		// 출력: 결과값 확인하기

		System.out.println("--------------------------------------------------------");
		System.out.printf("%9s	%6s	%6s %6s %6s %4s %6s\n", "이름", "국어", "영어", "수학", "총점", "평균", "학점");

		System.out.println("--------------------------------------------------------");
		for (int i = 0; i < name.length; i++) {
			System.out.printf("%7s	%5d	%5d	%5d	%5d	%3.1f	%5c\n", name[i], jumsu[i][0], jumsu[i][1], jumsu[i][2], tot[i],
					avg[i], grade[i]);
		}
		System.out.println("--------------------------------------------------------");

	}
}
