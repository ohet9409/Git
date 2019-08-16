
public class ife {

	public static void main(String[] args) {
		/*int score =85;
		if(score>=90) {
			System.out.println("점수가 90보다 큽니다");
			System.out.println("A등급입니다");
		}
		if(score<=90) {
			System.out.println("점수가 90보다 작습니다");
			System.out.println("B등급입니다");
		}
	}
		int score =85;
		if(score>=90) {
			System.out.println("점수가 90보다 큽니다");
			System.out.println("A등급입니다");
		}
		else {
			System.out.println("점수가 90보다 작습니다");
			System.out.println("B등급입니다");
		}
	}
		int score =75;
		if(score>=90) {
			System.out.println("점수가 100-90입니다");
			System.out.println("A등급입니다");
		}
		else if(score>=80) {
			System.out.println("점수가 89-80입니다");
			System.out.println("B등급입니다");
		}
		else if(score>=70) {
			System.out.println("점수가 79-70입니다");
			System.out.println("C등급입니다");
		}
		else  {
			System.out.println("점수가 70미만입니다");
			System.out.println("D등급입니다");
		}
	}

		int num = (int)(Math.random()*6)+1;
		if(num==1) {
			System.out.println("1번이 나왔습니다");
		}
		else if(num==2) {
			System.out.println("2번이 나왔습니다");
		}
		else if(num==3) {
			System.out.println("3번이 나왔습니다");
		}
		else if(num==4) {
			System.out.println("4번이 나왔습니다");
		}
		else if(num==5) {
			System.out.println("5번이 나왔습니다");
		}
		else  {
			System.out.println("6번이 나왔습니다");
		}*/
		int score = (int)(Math.random()*20)+81;
		String grade;
		System.out.println("점수: " + score);
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
		}System.out.println("학점: "+grade);
	}
}
