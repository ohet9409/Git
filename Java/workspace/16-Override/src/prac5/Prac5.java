package prac5;

public class Prac5 {
	public static void main(String[] args) {
		CircleArea ob1 = new CircleArea(10);
		CircleRound ob2 = new CircleRound(10);
		Circle ob3 = new CircleArea(16);
		ob1.compute();
		ob1.output();
		ob2.compute();
		ob2.output();
		ob3.compute();
		ob3.output();
	}
	
	
}
