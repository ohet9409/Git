import java.util.Scanner;

public class Prac14_1 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		int num1=0,num2=0,result=0;		//������ ���ڿ� ���� ����
		int cnt=0;						//�� Ƚ�� ����
		int answerCnt=0;				//����� ����
		int inputAnswer=0;				//�亯�� ����
		int startNum =10, endNum=99;	//���� ���� ���� ����
		char ch=0;						// y/n ����
		
		while(true) {
			num1 = (int)(Math.random() * (endNum - startNum + 1) + startNum);
			num2 = (int)(Math.random() * (endNum - startNum + 1) + startNum);
			result =num1+num2;
			cnt++; //���� Ƚ�� ����
			
			for(int x=1; x<=2; x++) {
				System.out.printf("[%d] %d + %d = ", cnt, num1, num2);
				inputAnswer = sc.nextInt();
				
				if(result == inputAnswer) {
					System.out.println("������");
					answerCnt++; 	//����� ����
					break;
				} else {
					System.out.print("Ʋ�ȴ�... ");
					if(x ==2) {
						System.out.println("����: "+result);
					}else System.out.println();
				}
			}
			//��� Ȯ�� �� ���α׷� ����
			if(cnt >= 5) {
				System.out.println();
				System.out.printf("����� �� %d������ ���߾ %d���Դϴ�.\n", answerCnt, answerCnt * 20);
				do {
				System.out.print("coutinue(y/n) : ");
				ch = sc.next().charAt(0);
				
				if(ch=='n') {
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
				}
				}while( ch !='y');
				
				
				cnt =0;			//�� Ƚ�� �ʱ�ȭ
				answerCnt=0;	//����� �ʱ�ȭ
			}
			System.out.println();		//���� �ѱ�
			
		}
	}
}
