package exam2;

public class Exam2 {
	public static void main(String[] args) {
		// �δ� ����
		Unit[] units = new Unit[3]; // ��ü �迭, Ŭ���� ���۷��� �迭, �θ� Ŭ���� ����
		units[0] = new Army("����");
		units[1] = new Navy("�ر�");
		units[2] = new AirForce("����");
		// �δ� �ϰ� ����
		for(int x = 0 ; x< units.length; x++) {
			units[x].attack();
			
			if(units[x] instanceof Army) {	// instanceof: ��ü�˻� ��ɾ� 
				Army army = (Army) units[x];
				army.tank();
			}else if(units[x] instanceof Navy){
				Navy navy = (Navy) units[x];
				navy.nucleus();
			}else if(units[x] instanceof AirForce) {
				AirForce airForce = (AirForce) units[x];
				airForce.bombing();
			}
		}
	}
}
