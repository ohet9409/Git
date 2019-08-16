import java.util.Scanner;

public class Prac14 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int startNum = 10;
		int endNum = 99;
		int result1 = 0;
		int result2 = 0;
		int dap = 0;
		int input = 0;
		int jumsu=0;
		int num = 1;
		int re = 0;

		while (true) {
			double r = Math.random();
			double r1 = Math.random();
			result1 = (int) (r * (endNum - startNum + 1) + startNum);
			result2 = (int) (r1 * (endNum - startNum + 1) + startNum);
			dap = result1 + result2;
			System.out.printf("[%d] %d + %d = ", num, result1, result2);
			input = sc.nextInt();
			if (input != dap && re != 2) {
				System.out.println("틀렸따...");
				System.out.printf("[%d] %d + %d = ", num, result1, result2);
				input = sc.nextInt();
				re++;

			}
			if (input == dap) {
				System.out.println("딩동댕");
				result1 = 0;
				result2 = 0;
				jumsu++;
				
			}
			if(input!=dap && re==1) {
				System.out.println("틀렸따.. 정답 : "+(result1+result2));
				re=0;
				num++;
			}
			if(input == dap || re==1) {
				num++;
				re=0;
			}
			if (num == 6)
				break;
		}
		System.out.printf("당신은 총 %d문제를 맞추어서 %d점입니다.", jumsu, jumsu * 20);

	}
}
