package prac6;

import java.util.Scanner;

public class Controller {
	Scanner sc = new Scanner(System.in);
	// EmpVO vo1, vo2, vo3, vo4, vo5
	EmpVO[] list = new EmpVO[5];	// ���۷��� ���� 5�� �����
	int numCnt=0;
	 void input() {
		if(numCnt < 5) {
			list[numCnt] = new EmpVO();	// ��ü �迭 0��������  �ʱ�ȭ -> ������ �Լ� ȣ�� �ݵ�� �ʿ�
			System.out.print("�̸� : ");
			list[numCnt].setName(sc.next()); // ������ ��ü �迭�� �Է� �޴´�.
			System.out.print("���� : ");
			list[numCnt].setSalary(sc.nextInt());
			System.out.print("�μ� : ");
			list[numCnt].setDepartment(sc.next());
			numCnt ++;
		}
		else {
			System.out.println("5����� �Է�");
		}
		
	}
	public void output() {
		for(int i=0; i<numCnt; i++)
		System.out.println(list[i].toString());
	}
}
