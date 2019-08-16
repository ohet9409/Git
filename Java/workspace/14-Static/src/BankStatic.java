
public class BankStatic {
	private String name;
	private double balance;
	private static double rate;	// 모든 객체가 공유해서 사용하고 싶어서 static을 붙였다 / 클래스와 독립된 변수
	
	public BankStatic(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	public void print_account() {
		System.out.println(name + "\t" + balance + "원\t" + BankStatic.rate + "%");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		BankStatic.rate = rate;
	}
	
	
}
