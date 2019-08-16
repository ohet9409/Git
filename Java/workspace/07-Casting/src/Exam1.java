
public class Exam1 {

	public static void main(String[] args) {
		short s = 100;
		int i = s;
		long l = i;
		float f = l;
		double d = f;

		System.out.println("s = " + s);
		System.out.println("i = " + i);
		System.out.println("l = " + l);
		System.out.println("f = " + f);
		System.out.println("d = " + d);

//		d = 100;
		/*
		 * f=d; i=5.5; char ch =s;
		 */ // ->에러
		char ch = 'a';
		int num = ch;	// 문자를 정수로 변환
		System.out.println("num = " + num);
	}

}
