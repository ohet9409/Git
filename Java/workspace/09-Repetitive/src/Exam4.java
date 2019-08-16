
public class Exam4 {
	public static void main(String[] args) {
		int sum=0;
		int x=1;
		while(true) {//조건식 자리에 true를 사용하면, 조건식을 블럭안에 위치를 자유롭게 배치할수 있음
			
			
			sum+=x;
			x++;
			if(x>10) break;
		}
		System.out.println("sum = " +sum);
	}
}
