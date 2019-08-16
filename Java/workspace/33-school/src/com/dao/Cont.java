package com.dao;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Cont {
	Scanner sc = new Scanner(System.in);
	Dao dao = new Dao();

	public void menu() {
		int num = 0;
		while (true) {
			System.out.println("*************");
			System.out.println("           ����");
			System.out.println("*************");
			System.out.println("  1. �Է�");
			System.out.println("  2. �˻�");
			System.out.println("  3. ����");
			System.out.println("  4. ����");
			System.out.println("  5. ����");
			System.out.println("  6. ��ŷ");
			System.out.println("*************");
			System.out.print(" ��ȣ���� : ");
			num = sc.nextInt();
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
				update();
				break;
			case 5:
				System.out.println("���α׷� ���� !!");
				System.exit(0);
			}
			System.out.println();
		}
	}
//
//	private void rank() {
//		dao.ShowRank();
//		
//	}

	private void insert() {
		int num = 0;
		String name = "";
		String value = "";
		int code = 0;
		while (true) {
			do {
				System.out.println("*************");
				System.out.println("  1. �л�");
				System.out.println("  2. ����");
				System.out.println("  3. ������");
				System.out.println("  4. �����޴�");
				System.out.println("*************");
				System.out.print(" ��ȣ���� : ");
				num = sc.nextInt();
			} while (num < 1 || num > 4);
			if (num == 4)
				return; // �����޴� ���ư���
			System.out.println();
			// �̸� �Է�
			System.out.print("�̸� �Է� : ");
			name = sc.next();
			switch (num) {
			case 1:
				System.out.print("�й� �Է� : ");
				value = sc.next();
				code = 1;
				break;
			case 2:
				System.out.print("���� �Է� : ");
				value = sc.next();
				code = 2;
				break;
			case 3:
				System.out.print("�μ� �Է� : ");
				value = sc.next();
				code = 3;
				break;

			}
			System.out.println();
			Dto dto = new Dto();
			dto.setName(name);
			dto.setValue(value);
			dto.setCode(code);
			int su = dao.insertArticle(dto);
			if (su > 0) {
				System.out.println("���� ����");
			} else {
				System.out.println("���� ����");
			}
		}
	}

	private void output(Dto dto) {
		System.out.print("�̸� : " + dto.getName());
		if (dto.getCode() == 1) {
			System.out.print("\t �й� : " + dto.getValue());
		} else if (dto.getCode() == 2) {
			System.out.print("\t ���� : " + dto.getValue());
		} else if (dto.getCode() == 3) {
			System.out.print("\t �μ� : " + dto.getValue());
		}
		System.out.print("\t �ڵ� : " + dto.getCode());
		System.out.println("\t ��ŷ : " + dto.getRank());
	}

	private void select() {
		String name = null;
		List<Dto> list = null;
		int num = 0;
		while (true) {
			do {
				System.out.println("*************");
				System.out.println("  1. �̸� �˻�");
				System.out.println("  2. ��ü �˻�");
				System.out.println("  3. �����޴�");
				System.out.println("*************");
				System.out.print(" ��ȣ���� : ");
				num = sc.nextInt();
			} while (num < 1 || num > 3);
		if (num == 3)
			return; // �����޴� �ǵ��� ����
		switch (num) {
		case 1:
			System.out.print("�˻��� �̸� �Է� : ");
			name = sc.next();
//			list = dao.ShowName(name);
//			list = dao.ShowRank(name);
			list = dao.ShowName(name);
			break;
		case 2:
			list = dao.ShowRank();
			break;
		}
		// ����Ʈ�� ����� ������ ����ϱ�
		for (int i = 0; i < list.size(); i++) {
			Dto dto = list.get(i);
			output(dto);
		}
	}}

	

	private void delete() {
		String name = null;
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		name = sc.next();
		int su = dao.deleteArticle(name);
		if(su>0)
			System.out.println("���� ����!!");
		else System.out.println("���� ����!!");
	}
	private void update() {
		Dto dto = new Dto();
		System.out.print("������ ���ϴ� �̸� �Է� : ");
		String name = sc.next();
		int code = 0;
		String value = null;
		int num=0;
		do {
			System.out.println("*************");
			System.out.println("  1. �л�");
			System.out.println("  2. ����");
			System.out.println("  3. ������");
			System.out.println("*************");
			System.out.print(" ��ȣ���� : ");
			num = sc.nextInt();
		} while (num < 1 || num > 3);
		switch (num) {
		case 1:
			System.out.print("�й� �Է� : ");
			value = sc.next();
			code = 1;
			break;
		case 2:
			System.out.print("���� �Է� : ");
			value = sc.next();
			code = 2;
			break;
		case 3:
			System.out.print("�μ� �Է� : ");
			value = sc.next();
			code = 3;
			break;

		}
		dto.setName(name);
		dto.setValue(value);
		dto.setCode(code);
		int su = dao.updateArticle(dto);
		if(su>0) System.out.println("���� ���� !!");
		else System.out.println("���� ���� !!");
	}
	public String searchID(String name) {
		List<Dto> list = new ArrayList<Dto>();
		boolean isExist = false;
		String result = "";
		Iterator<Dto> it = list.iterator();
		while(it.hasNext()) {
			Dto dto = it.next();
			if(dto.getName().equals(name)) {
				result += dto.toString() +"\n";
				isExist = true;
			}
		}
		if (isExist == true)
			return result;
		else
			return "�ش� �Ǵ� ����� �����ϴ�.";
	}
}
