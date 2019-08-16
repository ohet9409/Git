package exam5;

import java.util.Calendar;
import java.util.Scanner;

public class InfinityCalendar {
	// ����
	Scanner sc = new Scanner(System.in);
	Calendar calendar = Calendar.getInstance();
	int y, m; // ��, �� ����
	int dayNum;	//���ϼ� ����
	// �Է�
	void input() {
		do {
			System.out.print("�⵵? ");
			y = sc.nextInt();
		}while(y<1);
		do {
			System.out.print("��? ");
			m = sc.nextInt();
		}while(m<1 || m>12);
	}
	// ����
	void setDate() {
		calendar.set(y, m-1,1); // �Է¹��� �⵵, �� �� 1��
		// ���õ� �׳��� ù���� ���� �� ������
		dayNum=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("���ϼ� = " + dayNum);
	}
	// ���
	void outputTitle() {
		System.out.println();
		System.out.printf(" %2s   %2s   %2s  %2s  %2s   %2s   %2s\n","��","��", "ȭ","��","��","��","��");
		System.out.println("---------------------");
	}
	void output() {		
		setDate();
		outputTitle();
		// �̹����� ���ϼ� ���ϱ�
		int daysofMonth = calendar.getActualMaximum(Calendar.DATE);
		// ���ϼ���ŭ Ŀ�� �ű��
		for(int i=1; i<dayNum; i++) {		// ù �� 
			System.out.printf("%2s "," ");
		}
		// ��¥ ���
		for(int i=1; i<=daysofMonth; i++) {
			System.out.printf("%2d ",i);
			if(dayNum % 7 == 0) {	//��������� �˻� (������� ���ϼ�: 7)
				System.out.println();
			}
			dayNum++;
		}
		System.out.println();
		System.out.println("---------------------");
	}
}
