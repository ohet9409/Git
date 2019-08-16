import java.util.Scanner;
// 삼각형의 넓이 구하기
class Triangle {
	// 선언
	int base, height;
	// 입력
	void setTriangle(int b, int h) {
		base = b;
		height = h;
	}
	void setTriangle(){
		Scanner sc = new Scanner(System.in);
		System.out.print("밑변 : ");
		base = sc.nextInt();
		
		System.out.print("높이 : ");
		height = sc.nextInt();
	}
	// 연산
	double getArea() {
		return ((double)base * height)/2;
	}

	// 출력
	void output() {
		System.out.println("삼각형의 넓이 : " + getArea());	// 같은 클래스의 함수 출력
	}
}
public class Prac1 {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		System.out.println("***** 삼각형 넓이 구하기 *****\n");
		t.setTriangle();	//t클래스의 함수 출력
		t.output();
	}
}
