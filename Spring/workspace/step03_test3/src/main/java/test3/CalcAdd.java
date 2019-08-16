package test3;

public class CalcAdd implements Calc{
	private int x;
	private int y;
	public CalcAdd() {
	
	}
	public CalcAdd(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void calculate() {
		
		System.out.println(x + " + " + y + " = " + (x+y));
	}

}
