
public class CalcChild extends CalcParent {
	public int multiply(int x, int y) {
		return x*y;
	}
	public int divide(int x, int y) {
		int result=0;
		if(y!=0) result =x/y;
		return result;
	}
	public int plus(int x, int y) {
		System.out.println("child");
		return x + y;
	}
	public int minus(int x, int y) {
		System.out.println("child");
		System.out.println("�θ� �÷���"+super.plus(90,50));	//CalcParent�� plus�Լ��� ȣ��
		return x - y;
	}

}
