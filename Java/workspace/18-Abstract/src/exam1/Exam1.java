package exam1;

public class Exam1 {
			// ��ӵ� Ŭ���� ����
			/* 1. �ڽ� Ŭ���� ����(�⺻ ����)
			 * 2. �θ� Ŭ���� ����(������ ����)
			 * */
	public static void main(String[] args) {
		// 1. �ڽ� Ŭ���� ����
		Army army = new Army("����");
		Navy navy = new Navy("�ر�");
		AirForce airForce = new AirForce("����");
		army.move();
		army.attack();
		navy.move();
		navy.attack();
		airForce.move();
		airForce.attack();
		System.out.println("------------");		
		// 2. �θ� Ŭ���� ���� (��ü �迭 �̿� ����)
		//Unit u1, u2, u3;
//		Unit[] units = new Unit[3];
//		units[0] = new Army("����");
//		units[1] = new Navy("�ر�");
//		units[2] = new AirForce("����");
//		for(int i = 0; i<3; i++) {
//			units[i].move();
//			units[i].attack();
//		}
//		
		Unit[] units = new Unit[3]; // ��ü �迭 ����
		units[0] = new Army("����");
		units[1] = new Navy("�ر�");
		units[2] = new AirForce("����");
		for(int i =0 ; i<units.length; i++) {
			units[i].move();
			units[i].attack();
		}
	}

}
