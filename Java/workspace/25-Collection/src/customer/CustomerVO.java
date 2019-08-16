package customer;

public class CustomerVO {
	private String num;
	private String name;
	private String tel;
	
	@Override
	public String toString() {
		return "CustomerVO [num=" + num + ", name=" + name + ", tel=" + tel + "]";
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
