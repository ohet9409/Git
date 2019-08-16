package aop01;

public class Man {
	public void classWork() {
		// before
		System.out.println("교실문을 연다.");
		try {
			// pointcut or joinpoint
			System.out.println("컴퓨터를 켜고 game을 시작한다.");
		} catch (Exception e) {
			// after throwing
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			// after
			System.out.println("전등이 켜져있는 지 확인한다.");
		}
		// after advice
		System.out.println("교실문을 잠근다.");
	}
}
