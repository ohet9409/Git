interface Calculate{
	int operation(int a, int b);
}
public class Exam10 {

	public static void main(String[] args) {
		// �������̽��� ���� Ŭ������ ���
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
		// ���� ǥ�������� ��ȯ 1
		Calculate calculateAdd1 = (int a, int b) -> {return a+b;};
		System.out.println(calculateAdd1.operation(200, 300));
		
		// ���� ǥ�������� ��ȯ 2
		Calculate calculateAdd2 = (int a, int b) -> a+b;
		System.out.println(calculateAdd2.operation(300, 400));
		
		// ���� ǥ�������� ��ȯ 3
		Calculate calculateAdd3 = (a,b) -> a+b;
		System.out.println(calculateAdd3.operation(400, 500));
		
		// ���� ǥ�������� ��ȯ 4
		System.out.println(
				((Calculate)(int a, int b) -> {return a+b;}).operation(500, 600)
				);
	}

}
