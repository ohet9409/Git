class Living {
	void live() {
		System.out.println("����ִ�.");
	}
	void move() {
		System.out.println("Livig: �����δ�.");

	}
	void walk() {
		System.out.println("Living: �׹߷� �ȴ´�");

	}
}

class Animal extends Living {
	void breath() {
		System.out.println("��ҷ� ȣ���Ѵ�.");
	}

	void move() {
		System.out.println("�����δ�.");

	}
	void live() {
		System.out.println("�ʵ�???����ִ�.");
	}
	
}

class Mammalia extends Animal {
	void bringinpUp() {
		System.out.println("������ ������ �����Ѵ�.");
	}

	void walk() {
		System.out.println("�׹߷� �ȴ´�");

	}
}

public class Exam1 {
	public static void main(String[] args) {
		Living r1 = new Living();
		Living r2 = new Animal();
		Living r3 = new Mammalia();
		
		r1.live();
		r2.live();
		r3.live();
		
		r2.move();
		r3.walk();
	}

}
