
public class Test {
	      // 결과자료형(=리턴값의 자료형) : 컴퓨터에게 리턴값의 자료형을 알려주는 것   /* 리턴값이 없으면 void
	static int plus(int a, int b) {	//매개변수 : 다른 함수에서 전달된 값을 저장하는 변수
		return a + b;	// 되돌아 가라 : 호출된 곳으로, 그 즉시 되돌아 가라
	}         //결과값(= 리턴값) 	만일, 결과값이 있으면, 그 값을 가지고 되돌아간다.
	static void output(int cc) {
		System.out.println(cc);
	}
	public static void main(String[] args) {
		// 선언
		int c;
		// 입력
		// 연산
		c = plus(3,4);		// 함수의 호출 : 함수의 사용법
		// 출력
		output(c);
		return;	// 마지막 줄의 리턴값 없는 return은 생략 가능함.
	}
}
