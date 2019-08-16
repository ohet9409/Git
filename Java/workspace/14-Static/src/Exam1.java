
public class Exam1 {
	// 고객마다 이자율을 다르게 지정
	public static void main(String[] args) {
		System.out.println("-- 2000년 --");
		Bank hong = new Bank("홍길동", 10000, 2.5);
		hong.print_account();
		System.out.println("-- 2008년 --");
		Bank kim = new Bank("김철수", 20000, 4.5);
		hong.print_account();
		kim.print_account();
		System.out.println("-- 2019년 --");
		Bank lee = new Bank("이영희", 30000, 5.5);
		hong.print_account();
		kim.print_account();
		lee.print_account();
	}
}
