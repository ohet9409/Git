import java.util.Scanner;

class jumin{
	// ����
	Scanner sc = new Scanner(System.in);
	int genNum, year;
	String gender;
	// �Է�
	void input(){
		System.out.print("�ֹι�ȣ 7��° �ڸ��� �Է��ϼ��� : ");
		genNum = sc.nextInt();
	}
	// ����
	void calc() {
		switch (genNum) {
		case 1: year = 1900; gender = "����"; break;
		case 2: year = 1900; gender = "����"; break;
		case 3: year = 2000; gender = "����"; break;
		case 4: year = 2000; gender = "����"; break;
		default: System.out.println("�߸� �Է��߽��ϴ�");
		}
	}
	// ���
	void output(){
		if(year != 0)
		System.out.printf("����� %d���� %s�Դϴ�\n",year,gender);
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
