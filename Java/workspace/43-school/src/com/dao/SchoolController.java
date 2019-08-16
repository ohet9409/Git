package com.dao;

import java.util.Scanner;

public class SchoolController {
	SchoolDAO dao = new SchoolDAO();
	SchoolDTO dto = new SchoolDTO();
	Scanner sc = new Scanner(System.in);

	public void main() {
		int num = 0;
		System.out.println("**************");
		System.out.println("         관리");
		System.out.println("**************");
		System.out.println(" 1. 입력");
		System.out.println(" 2. 검색");
		System.out.println(" 3. 삭제");
		System.out.println(" 4. 종료");
		System.out.println("**************");
		System.out.print("번호선택 : ");
		num = sc.nextInt();
		while (true) {
			System.out.println();
			switch (num) {
			case 1:
				insert();
				break;
			case 2:
				select();
				break;
			case 3:
				delete();
				break;
			case 4:
				System.exit(0);

			}
		}
	}

	private void delete() {
		int num=0;
		System.out.print("삭제를 원하는 이름 입력 : ");
		String name = sc.next();
		int su = dao.deleteArticle(name);
		if(su>0) {
			System.out.println(su +"개의 행이 삭제되었습니다.");
		}
		else {
			System.out.println("삭제를 실패하였습니다.");
		}
		return;
	}

	private void select() {
		

	}

	private void insert() {
		int num = 0;
		String value = "";
		int code = 0;
		do {
			System.out.println("**************");
			System.out.println(" 1. 학생");
			System.out.println(" 2. 교수");
			System.out.println(" 3. 관리자");
			System.out.println(" 4. 이전메뉴");
			System.out.println("**************");
			System.out.print("번호선택 : ");
			num = sc.nextInt();
		} while (num < 1 || num > 4);
		if (num == 4)
			return;
		System.out.println();
		System.out.print("이름 입력 : ");
		String name = sc.next();
		switch (num) {
		case 1:
			System.out.print("학번 입력  : ");
			value = sc.next();
			code = 1;
			break;
		case 2:
			System.out.print("과목 입력  : ");
			value = sc.next();
			code = 2;
			break;
		case 3:
			System.out.print("부서 입력  : ");
			value = sc.next();
			code = 3;
			break;

		}
		dto.setName(name);
		dto.setCode(code);
		dto.setValue(value);
		int su = dao.insertArticle(dto);
		if (su > 0)
			System.out.println("저장성공");
		else
			System.out.println("저장실패");

	}

}