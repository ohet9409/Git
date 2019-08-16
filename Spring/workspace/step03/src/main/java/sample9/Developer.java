package sample9;

public class Developer{
	private Emp emp;
	private String dept;
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return emp.toString() + " 부서=" + dept + "(개발부)";
	}
	
}
