
public class Bank {
	private String name;	// ∞Ì∞¥∏Ì
	private double balance;	// ¿‹∞Ì
	private double rate;	// ¿∫«‡ ¿Ã¿≤
	
	public Bank(String name, double balance, double rate) {
		this.name = name;
		this.balance = balance;
		this.rate = rate;
	}
	public void print_account() {
		System.out.println(name + "\t" + balance + "ø¯\t"+ rate + "%");
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
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
