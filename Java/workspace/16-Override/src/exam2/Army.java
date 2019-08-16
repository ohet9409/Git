package exam2;

public class Army extends Unit{
	public Army(String name) {
		super(name);	// 부모클래스에서 name값을 받아온다.
	}
	@Override
	public void attack() {
		super.attack();	// 상속받은 Unit 클래스의 attack함수를 실행
		System.out.println(getName() + " >> 지상공격 실행함");
	}
	public void tank() {
		System.out.println(getName() + " >> 탱크 공격");
	}
}
