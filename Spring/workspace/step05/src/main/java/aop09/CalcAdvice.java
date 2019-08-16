package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class CalcAdvice {
	@Around("execution(* *(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("** 연산시작 **");
		joinPoint.proceed();
		System.out.println("** 연산종료 **");
	}
	
	@Before("execution(* *(..))")
	public void before() {
		System.out.println("** 연산 시작 **");
	}
	@After("execution(* *(..))")
	public void after() {
		System.out.println("** 연산 종료 **");
	}
}
