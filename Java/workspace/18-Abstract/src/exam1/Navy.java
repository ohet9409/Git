package exam1;

public class Navy extends Unit{

	public Navy(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		System.out.println(getName() + " >> 해상 공격");
		
	}

	@Override
	public void move() {
		System.out.println(getName() + " >> 해상 이동");
		
	}

}
