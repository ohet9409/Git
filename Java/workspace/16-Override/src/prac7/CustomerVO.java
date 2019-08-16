package prac7;

public class CustomerVO {
	private String num;
	private String name;
	private String tel;
	@Override
	public String toString() {
		
		return num +"\t"+ name +"\t"+tel ;
		
	}
	
	public CustomerVO(String num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	public CustomerVO() {
		super();
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
}
