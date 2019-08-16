package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
/*
 * @Aspect : 설정파일에서 advice 및 pointcut 등을 설정하지 않고, 자동적으로 advice를 적용
 */
@Aspect
public class MyAspect{	// 패키지명.클래스명.함수명(매개변수)
	// 실행시킬 핵심관심사항 함수를 정의한다.
	@Pointcut("execution(public void aop05.*.*(..))")
	public void myClass() {}
	
	// 핵심관심사항 함수 실행전에 실행
	@Before("myClass()")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실문을 연다.");
	}
	// 핵심관심사항 함수 실행후에 실행
	@After("myClass()")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실문을 닫는다.");
	}
	// 예외 발생하는 경우 실행
	@AfterThrowing(pointcut="myClass()", throwing="e")
	public void throwing(JoinPoint joinPoint, Throwable e) {
		System.out.println("** 오늘은 소독하는 날 **\n" + e.getMessage());
	}
}













