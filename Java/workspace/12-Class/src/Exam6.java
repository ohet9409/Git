import java.util.Scanner;
// 클래스 여러번 호출 예제
class Score{
	Scanner sc = new Scanner(System.in);
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	
	void set(){	// void set(Score this)
		System.out.println("this =" + this);
		System.out.print("학번: ");
		this.num = sc.nextInt();
		System.out.print("이름: ");
		this.name = sc.next();
		System.out.print("국어: ");
		this.kor = sc.nextInt();
		System.out.print("영어: ");
		this.eng = sc.nextInt();
		System.out.print("수학: ");
		this.mat = sc.nextInt();
		this.tot = kor + eng + mat;
		this.avg = tot/3;
		
	}
	void print_title() {	// print_title(Score this)
		System.out.println("this = " + this);
		System.out.println("*** 성적 출력 ***");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균");
	}
	void print() {			// print(Score this)
		System.out.println("this = " + this);
		System.out.println(this.num + "\t"+ this.name + "\t" + this.kor +  "\t" 
		+ this.eng+  "\t" + this.mat+  "\t" + this.tot+  "\t" + this.avg);
	}
}
public class Exam6 {
	
	public static void main(String[] args) {
		Score s1 = new Score();
		Score s2 = new Score();
		System.out.println("s1 = " + s1 + ", s2 = " + s2);
		
		s1.set();			// s1.set(s1)
		s2.set();			// s2.set(s2)
		s1.print_title();	// s1.print_title(s1)
		s1.print();			// s1.print(s1)
		s2.print();			// s2.print(s2)
	}
}
