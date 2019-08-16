package exam6;

import java.util.Calendar;

public class Exam6 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println((calendar.get(Calendar.MONTH)+1)+"월"+calendar.get(Calendar.DAY_OF_MONTH)+"일");
		
		Calc calc = Calc.getInstance();	// 생성자가 private라서 new를 사용하지 못함
		calc.plus(5, 7);
		calc.minus(5, 7);
		
		Calc.getInstance().plus(5, 7);
		Calc.getInstance().minus(5, 7);
	}
}
