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
	public abstract void attack(); // 중괄호(명령어) 사용할 수 없음
	public abstract void move();
}
