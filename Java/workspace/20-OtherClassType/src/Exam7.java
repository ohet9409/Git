import exam6.Calc;

public class Exam7 {

	public static void main(String[] args) {
		// 특정 패키지안의 클래스를 사용할 때
		// 1. class full name : 패키지명.클래스명
		exam6.Calc calc = exam6.Calc.getInstance();
		calc.plus(6, 8);
		// 2. import 사용
		Calc.getInstance().plus(5, 7);;
	}

}
