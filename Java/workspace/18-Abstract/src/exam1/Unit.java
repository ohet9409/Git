package exam1;

public abstract class Unit {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Unit(String name) {
		super();
		this.name = name;
	}
	public abstract void attack(); // �߰�ȣ(��ɾ�) ����� �� ����
	public abstract void move();
}
