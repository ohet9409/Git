package prac7_1;

import java.util.Scanner;

public class Customerimpl {
	// 선언
	Scanner sc = new Scanner(System.in);
	// CustomerVO aa1, aa2, aa3, aa4, aa5, aa6, aa7, aa8, aa9, aa10;
	CustomerVO[] vos = new CustomerVO[10]; // 객체배열, 클래스 레퍼런스 배열
	int Cnt = 0; // 고객 수 저장
	// 입력

	void input() {
		if (Cnt < vos.length) {
			vos[Cnt] = new CustomerVO();
			System.out.print("고객번호 : ");
			vos[Cnt].setNo(sc.next());
			System.out.print("이      름 : ");
			vos[Cnt].setName(sc.next());
			System.out.print("전화번호 : ");
			vos[Cnt].setTel(sc.next());
			Cnt++;
		} else {
			System.out.println("고객은 10명까지 입니다");
		}
	}

	// 연산
	void modify() {
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		// 고객이 있는 지 검사
		print_title();
		for (int i = 0; i < Cnt; i++) {
			if (vos[i].getName().equals(name)) {
				System.out.println(vos[i].toString());
				System.out.println();
				System.out.print("수정할 고객 번호 : ");
				vos[i].setNo(sc.next());
				System.out.print("수정할 고객 이름 : ");
				vos[i].setName(sc.next());
				System.out.print("수정할 고객 전화 번호 : ");
				vos[i].setTel(sc.next());
				break; // 첫번째 한명만 수정
			} else {
				System.out.println("수정할 데이터가 없습니다.");
				break;
			}
		}
	}

	void search() {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		print_title();
		for (int i = 0; i < Cnt; i++) {
			if (vos[i].getName().equals(name)) {
				System.out.println(vos[i].toString());
				System.out.println();
				break;
			} else {
				System.out.println("검색된 내용이 없습니다.");
				break;
			}
		}
	}

	// 출력
	void print_title() {
		System.out.println("고객번호\t이름\t전화번호");

	}

	void output() {
		print_title();
		for (int i = 0; i < Cnt; i++) {
			System.out.println(vos[i].toString());
		}
	}
}
