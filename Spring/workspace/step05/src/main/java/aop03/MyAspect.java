package aop03;
import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다.");
	}
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("** 오늘은 소독하는 날 **\n" + e.getMessage());
	}
}
