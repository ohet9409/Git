import java.util.Scanner;

class Parking {
	// ����
	Scanner sc = new Scanner(System.in);
	int num, position;
	boolean in;
	boolean[] space = new boolean[5];

	// �Է�
	void input_num() {
		System.out.println("���� ���� ���α׷�");
		System.out.println("************");
		System.out.println("1. ����");
		System.out.println("2. ����");
		System.out.println("3. ����Ʈ");
		System.out.println("4. ����");
		System.out.println("************");
		System.out.print("�޴� : ");
		num = sc.nextInt();
	}

	// ����
	// ���
	void input_position() {
		
		do {			// ��ġ�� 1~5������ �ޱ����� �ݺ��� ���
		System.out.print("��ġ �Է� : ");
		position = sc.nextInt();
		}while(position <1 || position>6);
	}
	void input_car() {
		input_position();
		System.out.println(position + "��ġ�� ����/");
		if(space[position-1]) System.out.println("�̹� �����Ǿ��ֽ��ϴ�");	// �ش� �迭�� ���� true�� ���
		else {
			System.out.println("�����Ǿ����ϴ�");
			space[position-1] = true;
		}
	}
	void output_car(){
		input_position();
		System.out.println(position + "��ġ�� ����/");
		if(space[position-1]) {System.out.println("�����Ǿ����ϴ�"); space[position-1] = false;}
		else {
			System.out.println("�����Ǿ� ���� �ʽ��ϴ�");	
	}
	}
	void print_list() {
		for(int x = 0; x<space.length; x++) {
			System.out.println((x+1) + "��ġ : " + space[x]);
		}
	}
	void endPgm() {
		System.out.println("���α׷��� �����մϴ�");
		System.exit(0);	// ���α׷� ����
	}
	void main() {
		while(true) {
			input_num();
			switch (num) {
			case 1: input_car(); 
				break;
			case 2: output_car(); 
			break;
			case 3: print_list();
			break;
			case 4: endPgm(); 
			break;
			}
			System.out.println();
		}
	}
		
}

public class Prac106 {
	
	public static void main(String[] args) {
		Parking parking = new Parking();
		parking.main();
	}
}
