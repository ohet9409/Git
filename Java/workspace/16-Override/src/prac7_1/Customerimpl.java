package prac7_1;

import java.util.Scanner;

public class Customerimpl {
	// ����
	Scanner sc = new Scanner(System.in);
	// CustomerVO aa1, aa2, aa3, aa4, aa5, aa6, aa7, aa8, aa9, aa10;
	CustomerVO[] vos = new CustomerVO[10]; // ��ü�迭, Ŭ���� ���۷��� �迭
	int Cnt = 0; // �� �� ����
	// �Է�

	void input() {
		if (Cnt < vos.length) {
			vos[Cnt] = new CustomerVO();
			System.out.print("����ȣ : ");
			vos[Cnt].setNo(sc.next());
			System.out.print("��      �� : ");
			vos[Cnt].setName(sc.next());
			System.out.print("��ȭ��ȣ : ");
			vos[Cnt].setTel(sc.next());
			Cnt++;
		} else {
			System.out.println("���� 10����� �Դϴ�");
		}
	}

	// ����
	void modify() {
		System.out.print("������ �̸� : ");
		String name = sc.next();
		// ���� �ִ� �� �˻�
		print_title();
		for (int i = 0; i < Cnt; i++) {
			if (vos[i].getName().equals(name)) {
				System.out.println(vos[i].toString());
				System.out.println();
				System.out.print("������ �� ��ȣ : ");
				vos[i].setNo(sc.next());
				System.out.print("������ �� �̸� : ");
				vos[i].setName(sc.next());
				System.out.print("������ �� ��ȭ ��ȣ : ");
				vos[i].setTel(sc.next());
				break; // ù��° �Ѹ� ����
			} else {
				System.out.println("������ �����Ͱ� �����ϴ�.");
				break;
			}
		}
	}

	void search() {
		System.out.print("�˻��� �̸� : ");
		String name = sc.next();
		print_title();
		for (int i = 0; i < Cnt; i++) {
			if (vos[i].getName().equals(name)) {
				System.out.println(vos[i].toString());
				System.out.println();
				break;
			} else {
				System.out.println("�˻��� ������ �����ϴ�.");
				break;
			}
		}
	}

	// ���
	void print_title() {
		System.out.println("����ȣ\t�̸�\t��ȭ��ȣ");

	}

	void output() {
		print_title();
		for (int i = 0; i < Cnt; i++) {
			System.out.println(vos[i].toString());
		}
	}
}
