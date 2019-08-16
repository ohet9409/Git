interface Calculate{
	int operation(int a, int b);
}
public class Exam10 {

	public static void main(String[] args) {
		// 인터페이스를 무명 클래스로 사용
		Calculate calculateAdd = new Calculate() {
			
			@Override
			public int operation(int a, int b) {
				return a +b;
			}
		};
		System.out.println(calculateAdd.operation(100, 200));
		int num =(new Calculate() {
			
			@Override
			public int operation(int a, int b) {
				
				return a+b;
			}
		}).operation(10, 20);
		System.out.println(num);
		// 람다 표현식으로 전환 1
		Calculate calculateAdd1 = (int a, int b) -> {return a+b;};
		System.out.println(calculateAdd1.operation(200, 300));
		
		// 람다 표현식으로 전환 2
		Calculate calculateAdd2 = (int a, int b) -> a+b;
		System.out.println(calculateAdd2.operation(300, 400));
		
		// 람다 표현식으로 전환 3
		Calculate calculateAdd3 = (a,b) -> a+b;
		System.out.println(calculateAdd3.operation(400, 500));
		
		// 람다 표현식으로 전환 4
		System.out.println(
				((Calculate)(int a, int b) -> {return a+b;}).operation(500, 600)
				);
	}

}
