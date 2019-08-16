package test1;

public class HelloSpring {
	public static void main(String[] args) {
		CalcAdd add = new CalcAdd();
		add.calculate(25, 36);
		
		CalcMul mul = new CalcMul();
		mul.calculate(25, 36);
		
		Calc calc = new CalcAdd();
		calc.calculate(25, 36);
		Calc calc2 = new CalcMul();
		calc2.calculate(25, 36);
	}
}
