package test;

import java.util.Scanner;


public class Controller {
	// 선언
	Scanner sc = new Scanner(System.in);
	PersonVO[] list = new PersonVO[5];	// 객체 배열 선언 : 레퍼런스 변수(주소 저장)
	int listCnt = 0; // 배열의 위치를 관리하는 변수
	// 입력
	void input() {
		if(listCnt <5) {
		list[listCnt] = new PersonVO();		// list[listCnt]을 PersonVO 생성자로 메모리 할당
		System.out.print("이름 : ");
		list[listCnt].setName(sc.next());
		System.out.print("나이 : ");
		list[listCnt].setAge(sc.nextInt());
		System.out.print("전화 : ");
		list[listCnt].setTel(sc.next());
		listCnt++;
		} else {
			System.out.println("인원은 5명까지 입니다.");
		}
	}
	// 연산
	// 출력
	void output() {
		for(int x =0; x<listCnt; x++) {		// 입력된 정보 수 대로 출력
			System.out.println(list[x].toString());
		}
	}
}
