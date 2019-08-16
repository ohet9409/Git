package aop08;

public class CoreEx {
	public void zeroMethod(int a, int b) {
		try {
			//정수로 나누기연산을 할때에는 0으로 나누면 에러가 발생할 수있기 때문에 try-catch 사용
			System.out.println(a + " / " + b + " = " + (a/b));
		} catch (Exception e) {
			throw new RuntimeException("0으로 나눌 수 없습니다.");
		}
	}
}
