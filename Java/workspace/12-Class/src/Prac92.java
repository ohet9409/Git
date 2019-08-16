class Sum{
	// 선언
	int tot;
	// 입력
	// 연산
	void sum() {
		for(int i=1; i<=100; i++) {
			tot += i;
			if(i%10 == 0) {		// 10의배수 일 경우
				System.out.printf("%2d ~ %3d = %3d\n",i-9,i,tot);
				tot=0;
			}
		}
	}
	// 출력
}
public class Prac92 {
	public static void main(String[] args) {
		Sum sum = new Sum();
		sum.sum();
	}
}
