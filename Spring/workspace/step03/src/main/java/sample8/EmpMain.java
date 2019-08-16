package sample8;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample8/applicationContext.xml");
		Developer dev = (Developer) context.getBean("dev");
		System.out.println(dev.toString());
		Engineer eng = (Engineer) context.getBean("eng");
		System.out.println(eng.toString());
		context.close();
		
		GenericXmlApplicationContext context2 =
				new GenericXmlApplicationContext("sample8/applicationContext2.xml");
		Developer dev2 = (Developer) context2.getBean("dev");
		System.out.println(dev2.toString());
		Engineer eng2 = (Engineer) context2.getBean("eng");
		System.out.println(eng2.toString());
		context2.close();
	}

}
