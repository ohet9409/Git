package exam2;

public class AirForce extends Unit{

	public AirForce(String name) {
		super(name);	// �θ�Ŭ�������� name���� �޾ƿ´�.
	}
	@Override
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> �̷�");
		System.out.println(getName() + " >> ���߰��� ������");
	}
	public void bombing() {
		System.out.println(getName() + " >> ����");
	}

}
