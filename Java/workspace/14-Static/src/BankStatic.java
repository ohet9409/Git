
public class BankStatic {
	private String name;
	private double balance;
	private static double rate;	// ��� ��ü�� �����ؼ� ����ϰ� �; static�� �ٿ��� / Ŭ������ ������ ����
	
	public BankStatic(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	public void print_account() {
		System.out.println(name + "\t" + balance + "��\t" + BankStatic.rate + "%");
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
