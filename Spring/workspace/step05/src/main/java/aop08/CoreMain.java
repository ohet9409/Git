package aop08;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CoreMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("aop08/applicationContext.xml");
		CoreEx coreEx = (CoreEx) context.getBean("core");
		coreEx.zeroMethod(5, 2);
		System.out.println("----------------------");
		coreEx.zeroMethod(5, 0);
		context.close();
	}

}
