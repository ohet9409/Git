package exam2;

public class Exam2 {
	public static void main(String[] args) {
		Army army = new Army("����");			//�θ�Ŭ������ name�� �ش� ���� �����Ѵ�.
		Navy navy = new Navy("�ر�");
		AirForce airForce = new AirForce("����");
		
		army.attack();
		army.tank();
		
		navy.attack();
		navy.nucleus();
		
		airForce.attack();
		airForce.bombing();
	}
}
