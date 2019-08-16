package test3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("test3/applicationContext.xml");
		Calc add = (Calc) context.getBean("add");
		add.calculate();
		
		Calc mul = (Calc) context.getBean("mul");
		mul.calculate();
		
		context.close();
	}

}
