
import java.util.Scanner;

class Gugudan9 {
	// ����
	Scanner sc = new Scanner(System.in);
	int dan;
	char con;

	// �Է�
	void input_dan() {
		System.out.print("�� ���� ������� �Է��Ͻÿ� : ");
		dan = sc.nextInt();
	}

	void input_ch() {
		System.out.print("�����Ͻÿ�(y:���): ");
		con = sc.next().charAt(0);
	}
	// ����
	// ���

	void output() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}
	// �Ѱ���
	void mainControl() {
		do {
			input_dan();
			output();
			input_ch();
			System.out.println();
		}while(con == 'y');
		System.out.println("�����մϴ�");
	}
}
public class Prac93_1 {
	public static void main(String[] args) {
		/** while�� ����ϴ� ù��° ��� */
//		Gugudan9 gugudan = new Gugudan9();
//		gugudan.mainControl();
		
		/** while�� ����ϴ� �ι�° ���*/
		Gugudan9 gugudan = new Gugudan9();
		do {
			gugudan.input_dan();
			gugudan.output();
			gugudan.input_ch();
		}while(gugudan.con == 'y');
		System.out.println("���α׷� ����");
	}
}
