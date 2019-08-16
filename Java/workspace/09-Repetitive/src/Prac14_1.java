import java.util.Scanner;

public class Prac14_1 {
	public static void main(String[] args) {
		// 선언
		Scanner sc = new Scanner(System.in);
		int num1=0,num2=0,result=0;		//문제의 숫자와 정답 저장
		int cnt=0;						//총 횟수 저장
		int answerCnt=0;				//정답수 저장
		int inputAnswer=0;				//답변값 저장
		int startNum =10, endNum=99;	//임의 정수 범위 설정
		char ch=0;						// y/n 저장
		
		while(true) {
			num1 = (int)(Math.random() * (endNum - startNum + 1) + startNum);
			num2 = (int)(Math.random() * (endNum - startNum + 1) + startNum);
			result =num1+num2;
			cnt++; //문제 횟수 증가
			
			for(int x=1; x<=2; x++) {
				System.out.printf("[%d] %d + %d = ", cnt, num1, num2);
				inputAnswer = sc.nextInt();
				
				if(result == inputAnswer) {
					System.out.println("딩동댕");
					answerCnt++; 	//정답수 증가
					break;
				} else {
					System.out.print("틀렸다... ");
					if(x ==2) {
						System.out.println("정답: "+result);
					}else System.out.println();
				}
			}
			//결과 확인 및 프로그램 종료
			if(cnt >= 5) {
				System.out.println();
				System.out.printf("당신은 총 %d문제를 맞추어서 %d점입니다.\n", answerCnt, answerCnt * 20);
				do {
				System.out.print("coutinue(y/n) : ");
				ch = sc.next().charAt(0);
				
				if(ch=='n') {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				}while( ch !='y');
				
				
				cnt =0;			//총 횟수 초기화
				answerCnt=0;	//정답수 초기화
			}
			System.out.println();		//한줄 넘김
			
		}
	}
}
