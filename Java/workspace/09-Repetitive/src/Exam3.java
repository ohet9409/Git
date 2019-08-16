
public class Exam3 {
	public static void main(String[] args) {
		int sum=0;
		int x=1; 	//for문의 초기값 역할
		while(x<=10) {
			sum +=x;
			x++; 	//for문의 증감식 역할
		}
		System.out.println("sum = "+sum);
	}
}
