
public class Exam6 {
	/** C언어 스타일  */
//	static int plusIntIntInt(int a, int b, int c) {
//		return a + b + c;
//	}
//	static int plusIntInt(int a, int b) {
//		return a + b;
//	}
//	static double plusDoubleDouble(double a, double b) {
//		return a + b;
//	}
//	static double plusDoubleInt(double a, int b) {
//		return a + b;
//	}
//	static double plusIntdouble(int a, double b) {
//		return a + b;
//	}
	/** JAVA 스타일  */   
	static int plus(int a, int b, int c) {
		return a + b + c;
	}
	static int plus(int a, int b) {
		return a + b;
	}
	static double plus(double a, double b) {
		return a + b;
	}
	static double plus(double a, int b) {
		return a + b;
	}
	static double plus(int a, double b) {
		return a + b;
	}
	public static void main(String[] args) {
		System.out.println(plus(5,7));			// plus(int, int)
		System.out.println(plus(5,7,9));		// plus(int, int, int)
		System.out.println(plus(5.2,7.8));		// plus(double, double)
		System.out.println(plus(5,7.8));		// plus(int, double)
		System.out.println(plus(5.5,7));		// plus(double, int)
	}
}
