
public class ife {

	public static void main(String[] args) {
		/*int score =85;
		if(score>=90) {
			System.out.println("������ 90���� Ů�ϴ�");
			System.out.println("A����Դϴ�");
		}
		if(score<=90) {
			System.out.println("������ 90���� �۽��ϴ�");
			System.out.println("B����Դϴ�");
		}
	}
		int score =85;
		if(score>=90) {
			System.out.println("������ 90���� Ů�ϴ�");
			System.out.println("A����Դϴ�");
		}
		else {
			System.out.println("������ 90���� �۽��ϴ�");
			System.out.println("B����Դϴ�");
		}
	}
		int score =75;
		if(score>=90) {
			System.out.println("������ 100-90�Դϴ�");
			System.out.println("A����Դϴ�");
		}
		else if(score>=80) {
			System.out.println("������ 89-80�Դϴ�");
			System.out.println("B����Դϴ�");
		}
		else if(score>=70) {
			System.out.println("������ 79-70�Դϴ�");
			System.out.println("C����Դϴ�");
		}
		else  {
			System.out.println("������ 70�̸��Դϴ�");
			System.out.println("D����Դϴ�");
		}
	}

		int num = (int)(Math.random()*6)+1;
		if(num==1) {
			System.out.println("1���� ���Խ��ϴ�");
		}
		else if(num==2) {
			System.out.println("2���� ���Խ��ϴ�");
		}
		else if(num==3) {
			System.out.println("3���� ���Խ��ϴ�");
		}
		else if(num==4) {
			System.out.println("4���� ���Խ��ϴ�");
		}
		else if(num==5) {
			System.out.println("5���� ���Խ��ϴ�");
		}
		else  {
			System.out.println("6���� ���Խ��ϴ�");
		}*/
		int score = (int)(Math.random()*20)+81;
		String grade;
		System.out.println("����: " + score);
		if(score>=90) {
			if(score>=95) {
			grade= "A+";
			}else {
			grade="A";
			}
		}else {
			if(score>=85) {
				grade="B+";
				
		}else {
			grade="B";
		}
		}System.out.println("����: "+grade);
	}
}
