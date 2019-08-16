package customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import score.ScoreVO;

public class CustomerImpl implements Customer{
	Scanner sc = new Scanner(System.in);
	List<CustomerVO> list = new ArrayList<CustomerVO>();
	@Override
	public void input() {
		CustomerVO vo = new CustomerVO();
		System.out.print("����ȣ : ");
		vo.setNum(sc.next());
		System.out.print("�̸� : ");
		vo.setName(sc.next());
		System.out.print("��ȭ : ");
		vo.setTel(sc.next());
		
		list.add(vo);
		
	}

	@Override
	public void searchNum() {
		
		
	}

	@Override
	public void searchName() {
		System.out.print("�˻��� �̸� : ");
		String name = sc.next();
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			CustomerVO vo =it.next();
			if(vo.getName().equals(name))
			System.out.println(vo.toString());
		}
			System.out.println();
	}

	@Override
	public void desSortNum() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AscSortName() {
		Comparator<CustomerVO> a= new Comparator<CustomerVO>() {

			@Override
			public int compare(CustomerVO o1, CustomerVO o2) {
				
				return o1.getName().compareTo(o2.getName());
			}
		};
		Collections.sort(list,a);
		print();
	}

	@Override
	public void printTitle() {
		String str = String.format("%s\t%s\t%s\n", "����ȣ","�̸�","��ȭ");
		System.out.println(str);
	}

	@Override
	public void print() {
		printTitle();
		Iterator<CustomerVO> it = list.iterator();
		while(it.hasNext()) {
			CustomerVO vo= it.next();
			System.out.println(vo.toString());
		}
		System.out.println();
	}
	
}
