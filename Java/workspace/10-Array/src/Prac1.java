import java.util.Scanner;

public class Prac1 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int total=0;
		double avg=0;
		int[] jumsu=new int[5];
		for(int x=1; x<=jumsu.length;x++) {
			System.out.printf("%d�� �л��� ������ �Է� : ",x );
			jumsu[x-1] = sc.nextInt();
			total+=jumsu[x-1]; 
		}
		avg=(double)total/jumsu.length;
		System.out.println("����: "+total+", "+"��� : "+avg);
	}
}
