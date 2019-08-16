package chr;

public class CarOE {

	public static void main(String[] args) {
		CarO car1 = new CarO();
		System.out.println("car1.company: "+car1.company);
		
		CarO car2 = new CarO("자가용");
		System.out.println("car2.company: "+car2.company);
		System.out.println("car2.model: "+car2.model);
		
		CarO car3 = new CarO("자가용","빨강");
		System.out.println("car3.company: "+car3.company);
		System.out.println("car3.model: "+car3.model);
		System.out.println("car3.color: "+car3.color);
		
		CarO car4 = new CarO("자가용","빨강",200);
		System.out.println("car4.company: "+car4.company);
		System.out.println("car4.model: "+car4.model);
		System.out.println("car4.color: "+car4.color);
		System.out.println("car4.maxSpeed: "+car4.maxSpeed);

	}

}
