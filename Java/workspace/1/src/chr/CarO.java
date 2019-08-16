package chr;

public class CarO {
	String company="현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	CarO() {
		
	}
	CarO(String model){
		this.model=model;
	}
	CarO(String model, String color){
		this.model=model;
		this.color=color;
	}
	CarO(String model, String color,int maxSpeed){
		this.model=model;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
}
