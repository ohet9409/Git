package exam5;

import java.util.Calendar;
import java.util.Scanner;

public class InfinityCalendar {
	// 선언
	Scanner sc = new Scanner(System.in);
	Calendar calendar = Calendar.getInstance();
	int y, m; // 년, 월 저장
	int dayNum;	//요일수 저장
	// 입력
	void input() {
		do {
			System.out.print("년도? ");
			y = sc.nextInt();
		}while(y<1);
		do {
			System.out.print("월? ");
			m = sc.nextInt();
		}while(m<1 || m>12);
	}
	// 연산
	void setDate() {
		calendar.set(y, m-1,1); // 입력받은 년도, 월 에 1일
		// 세팅된 그날의 첫날의 요일 수 얻어오기
		dayNum=calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("요일수 = " + dayNum);
	}
	// 출력
	void outputTitle() {
		System.out.println();
		System.out.printf(" %2s   %2s   %2s  %2s  %2s   %2s   %2s\n","일","월", "화","수","목","금","토");
		System.out.println("---------------------");
	}
	void output() {		
		setDate();
		outputTitle();
		// 이번달의 총일수 구하기
		int daysofMonth = calendar.getActualMaximum(Calendar.DATE);
		// 요일수만큼 커서 옮기기
		for(int i=1; i<dayNum; i++) {		// 첫 주 
			System.out.printf("%2s "," ");
		}
		// 날짜 출력
		for(int i=1; i<=daysofMonth; i++) {
			System.out.printf("%2d ",i);
			if(dayNum % 7 == 0) {	//토요일인지 검사 (토요일의 요일수: 7)
				System.out.println();
			}
			dayNum++;
		}
		System.out.println();
		System.out.println("---------------------");
	}
}
