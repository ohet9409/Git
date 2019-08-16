package sample2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FooTestApp {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample2/applicationContext.xml");
		Foo foo1 = (Foo) context.getBean("foo1");
		System.out.println("foo1 = " + foo1);
		foo1 = (Foo) context.getBean("foo1");
		System.out.println("foo1 = " + foo1);
		context.close();

	}

}
