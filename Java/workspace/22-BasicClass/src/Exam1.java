
public class Exam1 {

	public static void main(String[] args) {
		String a = "20";
		String b = "3.14";
		
		int num_a = Integer.parseInt(a);		// 문자열 정수 변환
		double num_b = Double.parseDouble(b);	// 문자열 실수 변환
		
		System.out.println(num_a + 100);
		System.out.println(num_b + 200);
		
		System.out.println(a + 100);
		System.out.println(b + 200);
		
		int x =5;
		Integer xx = 5;
		Integer xxx = new Integer(5);
		
		System.out.println(x+5);
		System.out.println(xx+5);
		System.out.println(xxx+5);
		
	}

}
