package exam2;

public class Exam2 {
	public static void main(String[] args) {
		// 부대 지정
		Unit[] units = new Unit[3]; // 객체 배열, 클래스 레퍼런스 배열, 부모 클래스 기준
		units[0] = new Army("육군");
		units[1] = new Navy("해군");
		units[2] = new AirForce("공군");
		// 부대 일괄 공격
		for(int x = 0 ; x< units.length; x++) {
			units[x].attack();
			
			if(units[x] instanceof Army) {	// instanceof: 객체검사 명령어 
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
