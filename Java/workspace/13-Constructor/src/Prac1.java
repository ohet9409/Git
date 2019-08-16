
class Triangle {
	int base, height;

	Triangle() {		// t1�� ������
		base = 0;
		height =0;
	}

	Triangle(int base, int height) {	// t2�� ������
		this.base = base;
		this.height = height;
	}
	
	void setTriangle(int base, int height) {	// t1�� ����Ҷ� �޼ҵ�
		this.base = base;
		this.height = height;
	}
	
	double getArea() {					// t1, t2 �����
		return (double)base*height/2;
	}

}

public class Prac1 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		t1.setTriangle(5, 12); // t1 �������� ������ ����
		System.out.println("�ﰢ���� ���� : " + t1.getArea());

		Triangle t2 = new Triangle(45, 7); // t2 �������� ������ ����
		System.out.println("�ﰢ���� ���� : " + t2.getArea());
	}
}
