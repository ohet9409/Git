package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// 공통 관심 사항 클래스
public class LoggingAdvice {
	// 매개변수로 호출을 가로챈 함수를 전달받음
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 호출을 가로챈 함수의 이름 얻어오기
		String methodeName = joinPoint.getSignature().getName();
		// stopwatch 기능
		StopWatch stopWatch = new StopWatch();
		System.out.println("Method : " + methodeName + " is Calling");
		stopWatch.start();
		System.out.println();
		
		joinPoint.proceed(); // 가로챈 함수를 실행
		
		stopWatch.stop();
		System.out.println("Method : " + methodeName + " was done.");
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeMillis() + "ms");
	}
}
