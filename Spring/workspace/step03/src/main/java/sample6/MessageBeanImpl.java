package sample6;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String phone;
	private Outputter outputter;
	
	public void helloCall() {
		String message = name + " : " + phone;
		try {
			outputter.output(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public MessageBeanImpl(String name) {
		super();
		this.name = name;
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

	public Outputter getOutputter() {
		return outputter;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	

}
