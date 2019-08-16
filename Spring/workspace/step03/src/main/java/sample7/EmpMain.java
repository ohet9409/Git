package sample7;

import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("sample7/applicationContext.xml");
		Emp dev = (Emp) context.getBean("dev");
		System.out.println(dev.toString());
		
		Emp eng = (Emp) context.getBean("eng");
		System.out.println(eng.toString());
		
		context.close();
	}

}
