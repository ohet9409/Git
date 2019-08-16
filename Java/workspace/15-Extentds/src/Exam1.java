
public class Exam1 {
	public static void main(String[] args) {
		CalcParent parent = new CalcParent();
		System.out.println(parent.plus(5, 7));
		System.out.println(parent.minus(5, 7));
		System.out.println();
		
		CalcChild child = new CalcChild();
		System.out.println(child.plus(5, 7));
		System.out.println(child.minus(5, 7));
		System.out.println(child.multiply(5, 7));
		System.out.println(child.divide(28, 4));
	}
}
