package prac1;
public class Department extends Salary{
	String department;
	
	

	public Department(String name, int salary, String department) {
		super(name, salary);	// 상속받은 Salary클래스에서 name, salary함수를 받아온다.
		this.department = department;
	}



	@Override	//함수 재정의
	public void viewinformation() {
		super.viewinformation();	// 부모 클래스의 viewinformation() 호출
		System.out.println("부서 : " + department);
	}
	
}
