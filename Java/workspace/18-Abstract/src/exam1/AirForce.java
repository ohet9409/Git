package exam1;

public class AirForce extends Unit{

	public AirForce(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		System.out.println(getName() + " >> ���� ����");
		
	}

	@Override
	public void move() {
		System.out.println(getName() + " >> ���� �̵�");
		
	}

}
