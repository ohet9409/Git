package prac5;

public class CircleArea extends Circle{
	
	
	public CircleArea(int r) {	
		super(r); // 부모 클래스에서 r값을 전달 받는다.
	}
	
	@Override
	public void compute() {
		size =r * r *PI;
		
	}
	@Override
	public void output() {
	System.out.println("원의 넓이 : " + size);
	}

}
