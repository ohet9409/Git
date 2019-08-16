package aop03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class StartMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("aop03/applicationContext.xml");
		Person person1 = (Person) context.getBean("woman");
		person1.classWork();
		System.out.println("------------------");
		Person person2 = (Person) context.getBean("man");
		person2.classWork();
		context.close();

	}

}
