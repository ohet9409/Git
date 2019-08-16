package exam1;

public class Army extends Unit {

	public Army(String name) {
		super(name);
		
	}

	@Override
	public void attack() {
		System.out.println(getName() + " >> ¿∞ªÛ ∞¯∞›");
		
	}

	@Override
	public void move() {
		System.out.println(getName() + " >> ¿∞ªÛ ¿Ãµø");
		
	}
	

}
