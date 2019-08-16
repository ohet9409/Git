package sample1;

public class MessageBeanImpl implements MessageBean{
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		super();
		System.out.println("MessageBeanImpl() 호출");
	}
	
	

	public MessageBeanImpl(String fruit) {
		super();
		this.fruit = fruit;
		System.out.println("MessageBeanImpl(String fruit) 호출");
	}
	
	public MessageBeanImpl(String fruit, int cost) {
		super();
		this.fruit = fruit;
		this.cost = cost;
		System.out.println("MessageBeanImpl(String fruit, int cost) 호출");
	}
	
	public void sayHello() {
		
			System.out.println("sayHello() 호출");
			System.out.println(fruit + "\t" + cost);
	}

	public void sayHello(String a, int b) {
		
		System.out.println("sayHello(String a, int b) 호출");
		System.out.println(a + "\t" + b);
	}

	public String getFruit() {
		return fruit;
	}



	public void setFruit(String fruit) {
		this.fruit = fruit;
		System.out.println("setFruit(String fruit) 호출");
	}



	public int getCost() {
		return cost;
	}



	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost(int cost) 호출");
	}
	
}
