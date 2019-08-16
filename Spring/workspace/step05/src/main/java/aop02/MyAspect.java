package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
// 첫번째거 선택
public class MyAspect implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object returnValue = null;
		// 대상 메소드 실행전
		System.out.println("교실문을 연다.");
		try {
			// 대상 메소드 실행(핵심관심사항 실행)
			returnValue = invocation.proceed();
			System.out.println("returnValue = " + returnValue);
		} catch (Exception e) {
			// 대상 객체 메소드 실행중, 예외 발생시 코드
			System.out.println("*** 오늘은 소독하는 날 ***");
		} finally {
			// 대상 객체 메소드 실행 후
			System.out.println("전등이 꺼저있는지 확인한다.");
		}
		// 대상 메소드 실행후
		System.out.println("교실문을 잠근다.");
		return returnValue;
	}

}
