
public class Prac1 {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Triangle t = new Triangle();
		
		r.setArea(10.5, 20.5);	// �θ�Ŭ������ setArea�Լ��� ȣ���Ѵ�.
		t.setArea(5.0, 9.0);	// �θ�Ŭ������ setArea�Լ��� ȣ���Ѵ�.
		System.out.println("�簢���� ���� : " + r.getArea());
		System.out.println("�ﰢ���� ���� : " + t.getArea());
		
		System.out.println("r = " + r);
		System.out.println("r.toString() = " + r.toString());

	}

}
