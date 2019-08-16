package prac1;

public class Prac1 {

	public static void main(String[] args) {
		Department ob = new Department("강호동", 85000000, "개발부");
		//부서명은 자식클래스, 이름, 연봉은 부모클래스 변수에 저장한다.
		ob.viewinformation();

	}

}
