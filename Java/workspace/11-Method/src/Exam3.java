
public class Exam3 {
	static double plus(double x, double y) {
		return x + y;
	}
	static double minus(double x, double y) {
		return x - y;
	}
	public static void main(String[] args) {
		double x=100.5;
		double y=200.7;
		double r= plus(x,y);
		System.out.println(x + " + " + y + " = " + r);
		x=10.5;
		y=20.7;
		System.out.println(x + " - " + y + " = " + minus(x,y));
	}
}
