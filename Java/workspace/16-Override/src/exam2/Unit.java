package exam2;

public class Unit {
	private String name;

	public Unit(String name) {
//		super();
		this.name = name;
	}
	public void attack() {
		System.out.println(name + " >> �����غ�");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
