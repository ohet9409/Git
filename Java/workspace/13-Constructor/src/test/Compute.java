package test;

public class Compute {
	
	private int x,y,sum, sub,mul;	// private 클래스 안에서만 사용: 변수선언때 권장
	private double div;
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
	public int getSum() {
		sum = x+y;
		return sum;
	}
	public int getSub() {
		sub = x-y;
		return sub;
	}
	public int getMul() {
		mul = x*y;
		return mul;
	}
	public double getDiv() {
		div = (double)x/y;
		return div;
	}
	public void outputTitle() {
		System.out.printf( "%5s %5s %5s %5s %7s %5s\n", "X",  "Y",  "SUM",  "SUB",  "MUL",  "DIV");
	}
	public void outputCalc() {
		System.out.printf("%5d %5d %5d %5d %7d %5.1f\n",x,y,sum,sub,mul,div);
	}
	
}

