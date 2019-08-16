import java.util.Scanner;

class jumin{
	// 선언
	Scanner sc = new Scanner(System.in);
	int genNum, year;
	String gender;
	// 입력
	void input(){
		System.out.print("주민번호 7번째 자리를 입력하세요 : ");
		genNum = sc.nextInt();
	}
	// 연산
	void calc() {
		switch (genNum) {
		case 1: year = 1900; gender = "남성"; break;
		case 2: year = 1900; gender = "여성"; break;
		case 3: year = 2000; gender = "남성"; break;
		case 4: year = 2000; gender = "여성"; break;
		default: System.out.println("잘못 입력했습니다");
		}
	}
	// 출력
	void output(){
		if(year != 0)
		System.out.printf("당신은 %d년대생 %s입니다\n",year,gender);
	}
}
public class Prac83 {
	public static void main(String[] args) {
		jumin jumin = new jumin();
		jumin.input();
		jumin.calc();
		jumin.output();
	}
	
	
}
