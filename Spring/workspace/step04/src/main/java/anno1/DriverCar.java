package anno1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverCar {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno1/bean.xml");
		
		Tire tire = (Tire) context.getBean("test");
		System.out.println(tire.getBrand());
		
		Car car = (Car) context.getBean("car");
		car.drive();
		
		context.close();
	}
}
