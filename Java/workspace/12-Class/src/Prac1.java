import java.util.Scanner;
// �ﰢ���� ���� ���ϱ�
class Triangle {
	// ����
	int base, height;
	// �Է�
	void setTriangle(int b, int h) {
		base = b;
		height = h;
	}
	void setTriangle(){
		Scanner sc = new Scanner(System.in);
		System.out.print("�غ� : ");
		base = sc.nextInt();
		
		System.out.print("���� : ");
		height = sc.nextInt();
	}
	// ����
	double getArea() {
		return ((double)base * height)/2;
	}

	// ���
	void output() {
		System.out.println("�ﰢ���� ���� : " + getArea());	// ���� Ŭ������ �Լ� ���
	}
}
public class Prac1 {
	public static void main(String[] args) {
		Triangle t = new Triangle();
		System.out.println("***** �ﰢ�� ���� ���ϱ� *****\n");
		t.setTriangle();	//tŬ������ �Լ� ���
		t.output();
	}
}
