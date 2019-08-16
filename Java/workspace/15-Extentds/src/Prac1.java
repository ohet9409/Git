
public class Prac1 {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		r.setArea(10.5, 20.5);	// 부모클래스의 setArea함수를 호출한다.
		t.setArea(5.0, 9.0);	// 부모클래스의 setArea함수를 호출한다.
		System.out.println("사각형의 넓이 : " + r.getArea());
		System.out.println("삼각형의 넓이 : " + t.getArea());
		
		System.out.println("r = " + r);
		System.out.println("r.toString() = " + r.toString());

	}

}
