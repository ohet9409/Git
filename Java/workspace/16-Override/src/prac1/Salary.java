package prac1;

public class Salary {
	String name;
	int salary;
	
	
	public Salary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}


	public void viewinformation() {
		System.out.println("�̸� : "+ name);
		System.out.println("���� : "+ salary);
	}
	
	
}
