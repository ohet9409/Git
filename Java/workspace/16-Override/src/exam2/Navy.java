package exam2;

public class Navy extends Unit{

	public Navy(String name) {
		super(name);	// �θ�Ŭ�������� name���� �޾ƿ´�.
		
	}
	@Override
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> ��� �߻�");
		System.out.println(getName() + " >> ���� ���");
	}
	public void nucleus() {
		System.out.println(getName() + " >> �ٹ̻���");
	}
}
