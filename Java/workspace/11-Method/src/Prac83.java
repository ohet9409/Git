
import java.util.Scanner;

// �ֹι�ȣ 7��° �ڸ��� �Է¹��� �� 
public class Prac83 {
	static int input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ 7��° �ڸ��� �Է��ϼ���: ");
		int genNum = sc.nextInt();
		return genNum;
	}

	static int genYear(int genNum) {
		int year = 0;
		if (genNum == 1)
			year = 1900;
		else if (genNum == 2)
			year = 1900;
		else if (genNum == 3)
			year = 2000;
		else if (genNum == 4)
			year = 2000;
		else
			year = 0;
		return year;
	}

	static String gender(int genNum) {
		String gender = null;
		if (genNum == 1)
			gender = "����";
		else if (genNum == 2)
			gender = "����";
		else if (genNum == 3)
			gender = "����";
		else if (genNum == 4)
			gender = "����";
		else
			gender = null;
		;
		return gender;
	}

	static void output(int year, String gender) {
		if (gender != null)
			System.out.println("����� " + year + "���� " + gender+ "�Դϴ�");
		else
			System.out.println("�߸��Է��ϼ̽��ϴ�");
	}

	public static void main(String[] args) {
		// ����: ���� �����
		int genNum = 0;
		int year = 0;
		String gender = null;
		// �Է�: ������ ������ �����ϱ�
		genNum = input();
		// ����: ����� ������ �����ϱ�
		year = genYear(genNum);
		gender = gender(genNum);
		// ���: ����� Ȯ���ϱ�
		output(year, gender);

	}

}
