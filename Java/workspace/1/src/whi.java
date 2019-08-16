
public class whi {

	public static void main(String[] args) throws Exception {
			/*int i=1;
			while(i<=10) {
				System.out.println(i);
				i++;
			}
		int sum=0;
		int i=1;
		while(i<=100) {
			sum=sum+i;
			i++;
		}
		System.out.println("1 부터 "+(i-1)+"까지의 합: "+sum);*/
		boolean run=true;
		int speed=0;
		int keyCode=0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("------------------------");
				System.out.println("1. 종속 | 2. 감속| 3. 중지");
				System.out.println("------------------------");
				System.out.println("선택:");
			}
		keyCode= System.in.read();
		if(keyCode==49) {
			speed++;
			System.out.println("현재 속도=" + speed);
		}else if(keyCode==50) {
			speed--;
			System.out.println("현재 속도=" + speed);
		}
		else if(keyCode==51) {
			run=false;
		}
	}
		System.out.println("프로그램이 종료되었습니다");
	}

}
