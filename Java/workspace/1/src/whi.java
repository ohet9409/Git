
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
		System.out.println("1 ���� "+(i-1)+"������ ��: "+sum);*/
		boolean run=true;
		int speed=0;
		int keyCode=0;
		
		while(run) {
			if(keyCode!=13 && keyCode!=10) {
				System.out.println("------------------------");
				System.out.println("1. ���� | 2. ����| 3. ����");
				System.out.println("------------------------");
				System.out.println("����:");
			}
		keyCode= System.in.read();
		if(keyCode==49) {
			speed++;
			System.out.println("���� �ӵ�=" + speed);
		}else if(keyCode==50) {
			speed--;
			System.out.println("���� �ӵ�=" + speed);
		}
		else if(keyCode==51) {
			run=false;
		}
	}
		System.out.println("���α׷��� ����Ǿ����ϴ�");
	}

}
