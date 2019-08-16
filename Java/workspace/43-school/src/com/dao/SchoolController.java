package com.dao;

import java.util.Scanner;

public class SchoolController {
	SchoolDAO dao = new SchoolDAO();
	SchoolDTO dto = new SchoolDTO();
	Scanner sc = new Scanner(System.in);

	public void main() {
		int num = 0;
		System.out.println("**************");
		System.out.println("         ����");
		System.out.println("**************");
		System.out.println(" 1. �Է�");
		System.out.println(" 2. �˻�");
		System.out.println(" 3. ����");
		System.out.println(" 4. ����");
		System.out.println("**************");
		System.out.print("��ȣ���� : ");
		num = sc.nextInt();
		while (true) {
			System.out.println();
			switch (num) {
			case 1:
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				delete();
				break;
			case 4:
				System.exit(0);

			}
		}
	}

	private void delete() {
		int num=0;
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		String name = sc.next();
		int su = dao.deleteArticle(name);
		if(su>0) {
			System.out.println(su +"���� ���� �����Ǿ����ϴ�.");
		}
		else {
			System.out.println("������ �����Ͽ����ϴ�.");
		}
		return;
	}

	private void select() {
		

	}

	private void insert() {
		int num = 0;
		String value = "";
		int code = 0;
		do {
			System.out.println("**************");
			System.out.println(" 1. �л�");
			System.out.println(" 2. ����");
			System.out.println(" 3. ������");
			System.out.println(" 4. �����޴�");
			System.out.println("**************");
			System.out.print("��ȣ���� : ");
			num = sc.nextInt();
		} while (num < 1 || num > 4);
		if (num == 4)
			return;
		System.out.println();
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		switch (num) {
		case 1:
			System.out.print("�й� �Է�  : ");
			value = sc.next();
			code = 1;
			break;
		case 2:
			System.out.print("���� �Է�  : ");
			value = sc.next();
			code = 2;
			break;
		case 3:
			System.out.print("�μ� �Է�  : ");
			value = sc.next();
			code = 3;
			break;

		}
		dto.setName(name);
		dto.setCode(code);
		dto.setValue(value);
		int su = dao.insertArticle(dto);
		if (su > 0)
			System.out.println("���强��");
		else
			System.out.println("�������");

	}

}