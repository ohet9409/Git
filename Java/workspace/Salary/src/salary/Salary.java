package salary;

import java.util.Scanner;

public class Salary {
	Scanner sc = new Scanner(System.in);
	SalaryVO[] list = new SalaryVO[20];
	int cnt = 0;

	public void input() {
		if (cnt < list.length) {
			list[cnt] = new SalaryVO();
			System.out.print("�̸� : ");
			list[cnt].setName(sc.next());
			System.out.print("���� : ");
			list[cnt].setGick(sc.next());
			System.out.print("�⺻�� : ");
			list[cnt].setKibon(sc.nextInt());
			System.out.print("���� : ");
			list[cnt].setSu(sc.nextInt());
			calc_se(cnt);
			calc_money(cnt);
			cnt++;
		} else {
			System.out.println("20 ����� �Է� ����");
		}

	}

	public void calc_se(int cnt) {
		if (cnt < list.length) {
			if (list[cnt].getKibon() > 4000000) {
				list[cnt].setSe(0.03);
			} else if (list[cnt].getKibon() <= 4000000 && list[cnt].getKibon() > 2000000) {
				list[cnt].setSe(0.02);
			} else {
				list[cnt].setSe(0.01);
			}
		}
	}

	public void calc_money(int cnt) {
		if (cnt < list.length) {
			list[cnt].setMoney((int) (list[cnt].getKibon() + list[cnt].getSu()
					- (list[cnt].getKibon() + list[cnt].getSu()) * list[cnt].getSe()));

		}
	}



	public void modify() {
		System.out.print("������ �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.println("�̸�\t����\t�⺻��\t  ����\t����\t����");
		for (int i = 0; i < cnt; i++) {
			if (list[i].getName().equals(name)) {
				System.out.println(list[i].toString());
				System.out.print("������ �̸� : ");
				list[i].setName(sc.next());
				System.out.print("������ ���� : ");
				list[i].setGick(sc.next());
				System.out.print("������ �⺻�� : ");
				list[i].setKibon(sc.nextInt());
				System.out.print("������ ���� : ");
				list[i].setSu(sc.nextInt());
				calc_se(i);
				calc_money(i);
				break;
			}
		}

	}

	public void search() {
		System.out.print("�˻��� �̸��� �Է��ϼ��� : ");
		String name = sc.next();
		System.out.println("�̸�\t����\t�⺻��\t  ����\t����\t����");
		for (int i = 0; i < cnt; i++) {
			if (list[i].getName().equals(name)) {
				System.out.println(list[i].toString());
			}
		}

	}

	public void output() {
		System.out.println("�̸�\t����\t�⺻��\t  ����\t����\t����");
		for (int i = 0; i < cnt; i++) {
			System.out.println(list[i].toString());
		}

	}
}
