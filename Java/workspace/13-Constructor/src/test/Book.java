package test;
public class Book{
	public String subject;
	public String content;
	
	public Book(){
		System.out.println("**** ������ ����� ****");
		subject = "java �Թ�";
		content = "java�� Ŭ���� �߽��� ����̴�.";
	}
	public void read() {
		System.out.println("------ read() ����� -------");
		System.err.println("���� : " + subject);
		System.err.println("���� : " + content);
	}
}