import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int total=0;
		double avg=0;
		int[] jumsu=new int[5];
		for(int x=1; x<=jumsu.length;x++) {
			System.out.printf("%d번 학생의 점수를 입력 : ",x );
			jumsu[x-1] = sc.nextInt();
			total+=jumsu[x-1]; 
		}
		avg=(double)total/jumsu.length;
		System.out.println("총점: "+total+", "+"평균 : "+avg);
	}
}
