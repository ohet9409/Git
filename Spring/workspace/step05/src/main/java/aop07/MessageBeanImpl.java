package aop07;
// Target Bean (핵심관심사항 클래스)
public class MessageBeanImpl implements MessageBean{
	private String name;
	@Override
	public void sayHello() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello, " + name + "!!");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
