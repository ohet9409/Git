import java.util.Scanner;

class Sungjuk{
	// ����
	Scanner sc = new Scanner(System.in);
	int kor, eng,tot;
	double avg;
	char hak;
	// �Է�
	void input(){
		System.out.print("�������� �Է� : ");
		kor = sc.nextInt();
		System.out.print("�������� �Է� : ");
		eng = sc.nextInt();
	}
	// ����
	void calc() {
		tot = kor + eng;
		avg = (double)tot / 2;
		switch ((int)avg /10) {
		case 10: 
		case 9: hak = 'A'; break;
		case 8: hak = 'B'; break;
		case 7: hak = 'C'; break;
		case 6: hak = 'D'; break;
		default: hak = 'F';
		}
	}
	// ���
	void output() {
		System.out.println("���� = " + tot);
		System.out.println("��� = " + avg);
		System.out.println("���� = " + hak);
	}
}
public class Prac82 {
	public static void main(String[] args) {
		Sungjuk aaa = new Sungjuk();
		aaa.input();
		aaa.calc();
		aaa.output();
	}
}
