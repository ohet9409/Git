package anno2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class FoodTest {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext("anno2/bean2.xml");
		
		MyFoodMgr myFoodMgr = (MyFoodMgr) context.getBean("myFood");
		System.out.println(myFoodMgr.toString());
		
		context.close();
	}
}
