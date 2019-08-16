package aop04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/*
 * @Aspect : 설정파일에서 advice 및 pointcut 등을 설정하지 않고, 자동적으로 advice를 적용
 */
@Aspect
public class MyAspect{	// 패키지명.클래스명.함수명(매개변수)
	@Before("execution(public void aop04.*.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	@After("execution(public void aop04.*.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다.");
	}
	// 예외 발생하는 경우 실행
	@AfterThrowing(pointcut="execution(public void aop04.*.*(..))", throwing="e")
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("** 오늘은 소독하는 날 **\n" + e.getMessage());
	}
}













