import java.util.Scanner;
// Ŭ���� ������ ȣ�� ����
class Score{
	Scanner sc = new Scanner(System.in);
	int num;
	String name;
	int kor, eng, mat, tot, avg;
	
	void set(){	// void set(Score this)
		System.out.println("this =" + this);
		System.out.print("�й�: ");
		this.num = sc.nextInt();
		System.out.print("�̸�: ");
		this.name = sc.next();
		System.out.print("����: ");
		this.kor = sc.nextInt();
		System.out.print("����: ");
		this.eng = sc.nextInt();
		System.out.print("����: ");
		this.mat = sc.nextInt();
		this.tot = kor + eng + mat;
		this.avg = tot/3;
		
	}
	void print_title() {	// print_title(Score this)
		System.out.println("this = " + this);
		System.out.println("*** ���� ��� ***");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���");
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
