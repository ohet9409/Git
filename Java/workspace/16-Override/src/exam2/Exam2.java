package exam2;

public class Exam2 {
	public static void main(String[] args) {
		Army army = new Army("육군");			//부모클래스의 name에 해당 값을 저장한다.
		Navy navy = new Navy("해군");
		AirForce airForce = new AirForce("공군");
		
		army.attack();
		army.tank();
		
		navy.attack();
		navy.nucleus();
		
		airForce.attack();
		airForce.bombing();
	}
}
