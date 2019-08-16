package prac6;

import java.util.Scanner;

public class Controller {
	Scanner sc = new Scanner(System.in);
	// EmpVO vo1, vo2, vo3, vo4, vo5
	EmpVO[] list = new EmpVO[5];	// 레퍼런스 변수 5개 만들기
	int numCnt=0;
	 void input() {
		if(numCnt < 5) {
			list[numCnt] = new EmpVO();	// 객체 배열 0번지부터  초기화 -> 생성자 함수 호출 반드시 필요
			System.out.print("이름 : ");
			list[numCnt].setName(sc.next()); // 생성된 객체 배열에 입력 받는다.
			System.out.print("연봉 : ");
			list[numCnt].setSalary(sc.nextInt());
			System.out.print("부서 : ");
			list[numCnt].setDepartment(sc.next());
			numCnt ++;
		}
		else {
			System.out.println("5명까지 입력");
		}
		
	}
	public void output() {
		for(int i=0; i<numCnt; i++)
		System.out.println(list[i].toString());
	}
}
