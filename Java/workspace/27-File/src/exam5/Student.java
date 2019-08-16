package exam5;

import java.io.Serializable;

// �л� 1���� �����͸� ��� ���� : �ڹ� ����
public class Student implements Serializable{
	private String name;
	private int age;
	private String addr;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	public Student() {
		super();
	}
	public Student(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
