package com.dao;

import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Scanner;


public class Cont {
	Scanner sc = new Scanner(System.in);
	Dao dao = new Dao();

	public void menu() {
		int num = 0;
		while (true) {
			System.out.println("*************");
			System.out.println("           관리");
			System.out.println("*************");
			System.out.println("  1. 입력");
			System.out.println("  2. 검색");
			System.out.println("  3. 삭제");
			System.out.println("  4. 수정");
			System.out.println("  5. 종료");
			System.out.println("  6. 랭킹");
			System.out.println("*************");
			System.out.print(" 번호선택 : ");
			num = sc.nextInt();
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
				update();
				break;
			case 5:
				System.out.println("프로그램 종료 !!");
				System.exit(0);
			}
			System.out.println();
		}
	}
//
//	private void rank() {
//		dao.ShowRank();
//		
//	}

	private void insert() {
		int num = 0;
		String name = "";
		String value = "";
		int code = 0;
		while (true) {
			do {
				System.out.println("*************");
				System.out.println("  1. 학생");
				System.out.println("  2. 교수");
				System.out.println("  3. 관리자");
				System.out.println("  4. 이전메뉴");
				System.out.println("*************");
				System.out.print(" 번호선택 : ");
				num = sc.nextInt();
			} while (num < 1 || num > 4);
			if (num == 4)
				return; // 이전메뉴 돌아가기
			System.out.println();
			// 이름 입력
			System.out.print("이름 입력 : ");
			name = sc.next();
			switch (num) {
			case 1:
				System.out.print("학번 입력 : ");
				value = sc.next();
				code = 1;
				break;
			case 2:
				System.out.print("과목 입력 : ");
				value = sc.next();
				code = 2;
				break;
			case 3:
				System.out.print("부서 입력 : ");
				value = sc.next();
				code = 3;
				break;

			}
			System.out.println();
			Dto dto = new Dto();
			dto.setName(name);
			dto.setValue(value);
			dto.setCode(code);
			int su = dao.insertArticle(dto);
			if (su > 0) {
				System.out.println("저장 성공");
			} else {
				System.out.println("저장 실패");
			}
		}
	}

	private void output(Dto dto) {
		System.out.print("이름 : " + dto.getName());
		if (dto.getCode() == 1) {
			System.out.print("\t 학번 : " + dto.getValue());
		} else if (dto.getCode() == 2) {
			System.out.print("\t 과목 : " + dto.getValue());
		} else if (dto.getCode() == 3) {
			System.out.print("\t 부서 : " + dto.getValue());
		}
		System.out.print("\t 코드 : " + dto.getCode());
		System.out.println("\t 랭킹 : " + dto.getRank());
	}

	private void select() {
		String name = null;
		List<Dto> list = null;
		int num = 0;
		while (true) {
			do {
				System.out.println("*************");
				System.out.println("  1. 이름 검색");
				System.out.println("  2. 전체 검색");
				System.out.println("  3. 이전메뉴");
				System.out.println("*************");
				System.out.print(" 번호선택 : ");
				num = sc.nextInt();
			} while (num < 1 || num > 3);
		if (num == 3)
			return; // 이전메뉴 되돌아 가기
		switch (num) {
		case 1:
			System.out.print("검색할 이름 입력 : ");
			name = sc.next();
//			list = dao.ShowName(name);
//			list = dao.ShowRank(name);
			list = dao.ShowName(name);
			break;
		case 2:
			list = dao.ShowRank();
			break;
		}
		// 리스트에 저장된 데이터 출력하기
		for (int i = 0; i < list.size(); i++) {
			Dto dto = list.get(i);
			output(dto);
		}
	}}

	

	private void delete() {
		String name = null;
		System.out.print("삭제를 원하는 이름 입력 : ");
		name = sc.next();
		int su = dao.deleteArticle(name);
		if(su>0)
			System.out.println("삭제 성공!!");
		else System.out.println("삭제 실패!!");
	}
	private void update() {
		Dto dto = new Dto();
		System.out.print("수정을 원하는 이름 입력 : ");
		String name = sc.next();
		int code = 0;
		String value = null;
		int num=0;
		do {
			System.out.println("*************");
			System.out.println("  1. 학생");
			System.out.println("  2. 교수");
			System.out.println("  3. 관리자");
			System.out.println("*************");
			System.out.print(" 번호선택 : ");
			num = sc.nextInt();
		} while (num < 1 || num > 3);
		switch (num) {
		case 1:
			System.out.print("학번 입력 : ");
			value = sc.next();
			code = 1;
			break;
		case 2:
			System.out.print("과목 입력 : ");
			value = sc.next();
			code = 2;
			break;
		case 3:
			System.out.print("부서 입력 : ");
			value = sc.next();
			code = 3;
			break;

		}
		dto.setName(name);
		dto.setValue(value);
		dto.setCode(code);
		int su = dao.updateArticle(dto);
		if(su>0) System.out.println("수정 성공 !!");
		else System.out.println("수정 실패 !!");
	}
	public String searchID(String name) {
		List<Dto> list = new ArrayList<Dto>();
		boolean isExist = false;
		String result = "";
		Iterator<Dto> it = list.iterator();
		while(it.hasNext()) {
			Dto dto = it.next();
			if(dto.getName().equals(name)) {
				result += dto.toString() +"\n";
				isExist = true;
			}
		}
		if (isExist == true)
			return result;
		else
			return "해당 되는 사람이 없습니다.";
	}
}
