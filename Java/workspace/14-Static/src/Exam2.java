
public class Exam2 {
	// 모든 고객의 이자율을 통일하는 예제
	public static void main(String[] args) {
		System.out.println("--- 2000년 ---");
		BankStatic.setRate(2.5);			// 모든 고객의 이자율을 2.5%로 고정
		BankStatic hong = new BankStatic("홍길동", 10000);
		hong.print_account();
		System.out.println("--- 2008년 ---");
		BankStatic.setRate(4.5);			// 모든 고객의 이자율을 4.5%로 고정
		BankStatic kim = new BankStatic("김철수", 20000);
		hong.print_account();
		kim.print_account();
		
		System.out.println("--- 2019년 ---");
		BankStatic.setRate(5.5);			// 모든 고객의 이자율을 5.5%로 고정
		BankStatic lee = new BankStatic("이영희", 50000);
		hong.print_account();
		kim.print_account();
		lee.print_account();
	}
}
