package prac1;
public class Department extends Salary{
	String department;
	
	

	public Department(String name, int salary, String department) {
		super(name, salary);	// ��ӹ��� SalaryŬ�������� name, salary�Լ��� �޾ƿ´�.
		this.department = department;
	}



	@Override	//�Լ� ������
	public void viewinformation() {
		super.viewinformation();	// �θ� Ŭ������ viewinformation() ȣ��
		System.out.println("�μ� : " + department);
	}
	
}
