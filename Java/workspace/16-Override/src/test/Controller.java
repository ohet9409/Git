package test;

import java.util.Scanner;


public class Controller {
	// ����
	Scanner sc = new Scanner(System.in);
	PersonVO[] list = new PersonVO[5];	// ��ü �迭 ���� : ���۷��� ����(�ּ� ����)
	int listCnt = 0; // �迭�� ��ġ�� �����ϴ� ����
	// �Է�
	void input() {
		if(listCnt <5) {
		list[listCnt] = new PersonVO();		// list[listCnt]�� PersonVO �����ڷ� �޸� �Ҵ�
		System.out.print("�̸� : ");
		list[listCnt].setName(sc.next());
		System.out.print("���� : ");
		list[listCnt].setAge(sc.nextInt());
		System.out.print("��ȭ : ");
		list[listCnt].setTel(sc.next());
		listCnt++;
		} else {
			System.out.println("�ο��� 5����� �Դϴ�.");
		}
	}
	// ����
	// ���
	void output() {
		for(int x =0; x<listCnt; x++) {		// �Էµ� ���� �� ��� ���
			System.out.println(list[x].toString());
		}
	}
}
