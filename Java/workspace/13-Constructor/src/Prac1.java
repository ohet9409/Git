
class Triangle {
	int base, height;

	Triangle() {		// t1의 생성자
		base = 0;
		height =0;
	}

	Triangle(int base, int height) {	// t2의 생성자
		this.base = base;
		this.height = height;
	}
	
	void setTriangle(int base, int height) {	// t1을 사용할때 메소드
		this.base = base;
		this.height = height;
	}
	
	double getArea() {					// t1, t2 결과값
		return (double)base*height/2;
	}

}

public class Prac1 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.setTriangle(5, 12); // t1 생성자의 데이터 전달
		System.out.println("삼각형의 넓이 : " + t1.getArea());

		Triangle t2 = new Triangle(45, 7); // t2 생성자의 데이터 전달
		System.out.println("삼각형의 넓이 : " + t2.getArea());
	}
}
