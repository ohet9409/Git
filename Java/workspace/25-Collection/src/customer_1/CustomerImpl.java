package customer_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerImpl implements Customer {
	// 선언
	Scanner sc = new Scanner(System.in);
	List<CustomerVO_1> list = new ArrayList<CustomerVO_1>();
	// 입력
	@Override
	public void input() {
		CustomerVO_1 vo = new CustomerVO_1();
		System.out.print("고객번호 : ");
		vo.setNo(sc.next());
		System.out.print("고객이름 : ");
		vo.setName(sc.next());
		System.out.print("고객전화 : ");
		vo.setPhone(sc.next());
		list.add(vo);
	}
	// 연산
	@Override
	public void searchNo() {
		System.out.print("검색할 고객번호 : ");
		String no = sc.next();
		// 확장 for문 사용
		for (CustomerVO_1 vo : list) {
			if (vo.getNo().equals(no)) {
				printTitle();
				System.out.println(vo.toString());
				break; // 한사람만 검색
			}
		}
	}
	@Override
	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		Iterator<CustomerVO_1> it = list.iterator();
		printTitle();
		while (it.hasNext()) { // 동명이인 모두 출력
			CustomerVO_1 vo = it.next();
			if (vo.getName().equals(name))
				System.out.println(vo.toString());
		}
	}

	@Override
	public void descSortName() {
		Comparator<CustomerVO_1> comparator = new Comparator<CustomerVO_1>() {

			@Override
			public int compare(CustomerVO_1 o1, CustomerVO_1 o2) {

				return o2.getName().compareTo(o1.getName());
			}
		};
		Collections.sort(list, comparator);
		print();
	}
	@Override
	public void ascSortNo() {
		Comparator<CustomerVO_1> comparator = new Comparator<CustomerVO_1>() {
			@Override
			public int compare(CustomerVO_1 o1, CustomerVO_1 o2) {
				// TODO Auto-generated method stub
				return o1.getNo().compareTo(o2.getNo());
			}
		};
		Collections.sort(list, comparator);
		print();
	}
	// 출력
	@Override
	public void printTitle() {
		String str = String.format("%6s,%7s, %13s", "고객번호", "고객이름", "고객전화");
		System.out.println(str);
	}
	@Override
	public void print() {
		printTitle();
		Iterator<CustomerVO_1> it = list.iterator();
		while (it.hasNext()) {
			CustomerVO_1 vo = it.next();
			System.out.println(vo.toString());
		}
		System.out.println();

	}

}
