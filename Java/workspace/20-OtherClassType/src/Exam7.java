import exam6.Calc;

public class Exam7 {

	public static void main(String[] args) {
		// Ư�� ��Ű������ Ŭ������ ����� ��
		// 1. class full name : ��Ű����.Ŭ������
		exam6.Calc calc = exam6.Calc.getInstance();
		calc.plus(6, 8);
		// 2. import ���
		Calc.getInstance().plus(5, 7);;
	}

}
