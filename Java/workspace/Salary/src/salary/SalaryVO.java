package salary;

public class SalaryVO {
	private String name; // 이름
	private String gick; // 직급
	private int kibon; // 기본급
	private int su; // 수당
	private double se; // 세율
	private int money; // 월급

	@Override
	public String toString() {
		return name + "\t" + gick + "\t" + kibon + "\t " + su + "\t" + se + "\t" + money + "\t";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGick() {
		return gick;
	}

	public void setGick(String gick) {
		this.gick = gick;
	}

	public int getKibon() {
		return kibon;
	}

	public void setKibon(int kibon) {
		this.kibon = kibon;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public double getSe() {
		return se;
	}

	public void setSe(double se) {
		this.se = se;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public SalaryVO(String name, String gick, int kibon, int su, double se, int money) {
		super();
		this.name = name;
		this.gick = gick;
		this.kibon = kibon;
		this.su = su;
		this.se = se;
		this.money = money;
	}

	public SalaryVO() {
		super();
	}

}
