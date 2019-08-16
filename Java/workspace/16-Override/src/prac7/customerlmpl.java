package prac7;

import java.util.Scanner;


public class customerlmpl {
	Scanner sc = new Scanner(System.in);
	CustomerVO[] list = new CustomerVO[10];
	int cnt =0;
	String name;
	void input() {
		if(cnt <10) {
			list[cnt] = new CustomerVO();
			System.out.print("고객 번호 : ");
			list[cnt].setNum(sc.next());
			
			System.out.print("이       름 : ");
			list[cnt].setName(sc.next());
			
			System.out.print("전화번호 : ");
			list[cnt].setTel(sc.next());
			cnt++;
		}else {
			System.out.println("10명 까지만 입력");
		}
		
	}
	 public void output() {
		 System.out.println("고객번호\t이름\t전화번호 ");
		 for(int x=0; x<cnt;x++) {
			 System.out.println(list[x].toString());
		 }
	}
	 public void sujung() {
		 System.out.println("수정할 이름 : ");
		 name = sc.next();
		 for(int i=0; i<cnt; i++) { 
			if(list[i].getName().equals(name)){
				System.out.println(list[i].toString());
				list[i] = new CustomerVO();
				System.out.print("고객 번호 : ");
				list[i].setNum(sc.next());
				
				System.out.print("이       름 : ");
				list[i].setName(sc.next());
				
				System.out.print("전화번호 : ");
				list[i].setTel(sc.next());
			}else {
				System.out.println("입력된 내용이 없습니다");
			}

		}
	 }
	 public void find() {
		System.out.println("검색할 이름 : ");
		name = sc.next();
		for(int i=0; i<cnt; i++) { 
			if(list[i].getName().equals(name)){
				System.out.println("고객번호\t이름\t전화번호 ");
				System.out.println(list[i].toString());
			}else {
				System.out.println("검색된 내용이 없습니다");
			}

		}

	}
}
