// 클래스 여러번 사용 예제
class Charactor {
	// 일반적으로 멤버변수는 선언만 한다.
	String name;	// 초기값 = null
	int age;		// 초기값 = 0 (문자,실수,정수) ,  boolean 초기값  = false 
}
public class Exam2 {
	public static void main(String[] args) {
		// 하나의 클래스가 정의되면, 그 클래스의 구조를 기반으로 하는 
		// 여러개의 데이터 덩어리(=객체)를 생성할 수 있다.
		Charactor d = new Charactor();		// d라는 객체 생성
		System.out.println("이름 : " + d.name + ", 나이 : " + d.age );
		d.name = "둘리";
		d.age = 19;
		
		Charactor h = new Charactor();		// h라는 객체 생성
		h.name = "희동";
		h.age = 3;
		
		System.out.println("이름 : " + d.name + ", 나이 : " + d.age );
		System.out.println("이름 : " + h.name + ", 나이 : " + h.age );
		
	}
}
