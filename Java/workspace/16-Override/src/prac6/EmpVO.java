package prac6;

public class EmpVO {
	private String name;
	private int salary;
	private String department;
	
	@Override
	public String toString() {
		return "EmpVO [name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
	
	public EmpVO() {
		super();
	}

	public EmpVO(String name, int salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
}
