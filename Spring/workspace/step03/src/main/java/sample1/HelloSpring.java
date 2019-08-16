package sample1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 2. 스프링으로 객체 생성 및 객체 사용
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample1/bean.xml");
		MessageBeanImpl bean2 = (MessageBeanImpl) context.getBean("messageBean");
		bean2.sayHello();
		
		MessageBeanImpl bean3 = (MessageBeanImpl) context.getBean("message2");
		bean3.sayHello();
		context.close();
		System.out.println("-------------------");
		
		// 1. 기존 방법으로 객체 생성 및 객체 사용
		MessageBeanImpl bean1 = new MessageBeanImpl("딸기");
		//bean1.setFruit("딸기");
		bean1.setCost(3000);
		bean1.sayHello();
		
	}
}
