package prac5;

public class CircleArea extends Circle{
	
	
	public CircleArea(int r) {	
		super(r); // �θ� Ŭ�������� r���� ���� �޴´�.
	}
	
	@Override
	public void compute() {
		size =r * r *PI;
		
	}
	@Override
	public void output() {
	System.out.println("���� ���� : " + size);
	}

}
