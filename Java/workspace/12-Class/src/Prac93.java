import java.util.Scanner;

class Gugudan {
	// ����
	Scanner sc = new Scanner(System.in);
	int dan;
	char con;

	// �Է�
	void input() {
		System.out.print("�� ���� ������� �Է��Ͻÿ� : ");
		dan = sc.nextInt(); 
	}

	// ����
	void calc() {
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}

	// ���
	void output() {
		System.out.print("�����Ͻÿ�(y:���): ");
		con = sc.next().charAt(0);
		if(con != 'y')
			System.out.println("�����մϴ�");
	}
}

public class Prac93 {
	public static void main(String[] args) {
		Gugudan gugudan = new Gugudan();
		do {
		gugudan.input();
		gugudan.calc();
		gugudan.output();
		}while(gugudan.con == 'y');
	}
}
