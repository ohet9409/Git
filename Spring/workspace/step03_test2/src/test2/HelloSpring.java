package test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("test2/applicationContext.xml");
		Calc calc = (Calc) context.getBean("add");
		calc.calculate();
		
		calc = (Calc) context.getBean("mul");
		calc.calculate();
		
		context.close();
	}

}
