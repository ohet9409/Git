package prac7;

import java.util.Scanner;


public class customerlmpl {
	Scanner sc = new Scanner(System.in);
	CustomerVO[] list = new CustomerVO[10];
	int cnt =0;
	String name;
	void input() {
		if(cnt <10) {
			list[cnt] = new CustomerVO();
			System.out.print("�� ��ȣ : ");
			list[cnt].setNum(sc.next());
			
			System.out.print("��       �� : ");
			list[cnt].setName(sc.next());
			
			System.out.print("��ȭ��ȣ : ");
			list[cnt].setTel(sc.next());
			cnt++;
		}else {
			System.out.println("10�� ������ �Է�");
		}
		
	}
	 public void output() {
		 System.out.println("����ȣ\t�̸�\t��ȭ��ȣ ");
		 for(int x=0; x<cnt;x++) {
			 System.out.println(list[x].toString());
		 }
	}
	 public void sujung() {
		 System.out.println("������ �̸� : ");
		 name = sc.next();
		 for(int i=0; i<cnt; i++) { 
			if(list[i].getName().equals(name)){
				System.out.println(list[i].toString());
				list[i] = new CustomerVO();
				System.out.print("�� ��ȣ : ");
				list[i].setNum(sc.next());
				
				System.out.print("��       �� : ");
				list[i].setName(sc.next());
				
				System.out.print("��ȭ��ȣ : ");
				list[i].setTel(sc.next());
			}else {
				System.out.println("�Էµ� ������ �����ϴ�");
			}

		}
	 }
	 public void find() {
		System.out.println("�˻��� �̸� : ");
		name = sc.next();
		for(int i=0; i<cnt; i++) { 
			if(list[i].getName().equals(name)){
				System.out.println("����ȣ\t�̸�\t��ȭ��ȣ ");
				System.out.println(list[i].toString());
			}else {
				System.out.println("�˻��� ������ �����ϴ�");
			}

		}

	}
}
