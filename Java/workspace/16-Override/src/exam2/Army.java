package exam2;

public class Army extends Unit{
	public Army(String name) {
		super(name);	// �θ�Ŭ�������� name���� �޾ƿ´�.
	}
	@Override
	public void attack() {
		super.attack();	// ��ӹ��� Unit Ŭ������ attack�Լ��� ����
		System.out.println(getName() + " >> ������� ������");
	}
	public void tank() {
		System.out.println(getName() + " >> ��ũ ����");
	}
}
