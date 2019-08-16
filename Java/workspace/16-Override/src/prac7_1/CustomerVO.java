package prac7_1;
// ¿⁄πŸ∫Û¡Ó
public class CustomerVO {
	private String no;
	private String name;
	private String tel;
	@Override
	public String toString() {
		return no + "\t" + name +"\t" + tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public CustomerVO(String no, String name, String tel) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
	}
	public CustomerVO() {
		super();
	}
	
}
