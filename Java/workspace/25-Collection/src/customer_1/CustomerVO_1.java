package customer_1;

public class CustomerVO_1 {
	private String no;	// °í°´¹øÈ£
	private String name; // °í°´¸í
	private String phone;	// °í°´ ÀüÈ­¹øÈ£
	@Override
	public String toString() {
		if(no == null || name == null) {
			return null;
		}
		String result = String.format("%6s,%7s, %13s", no,name,phone);
		return result;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
