package prac5;

public class CircleRound extends Circle{
	
	public CircleRound(int r) {
		super(r);	// 부모 클래스에서 r값을 전달 받는다.
		
	}
	
	@Override
	public void compute() {
		size = r * 2 * PI;
	}
	@Override
	public void output() {
		System.out.println("원의 둘레 : " + size);
	}
	
}
