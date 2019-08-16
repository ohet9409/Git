package test;
public class Book{
	public String subject;
	public String content;
	
	public Book(){
		System.out.println("**** 생성자 실행됨 ****");
		subject = "java 입문";
		content = "java는 클래스 중심의 언어이다.";
	}
	public void read() {
		System.out.println("------ read() 실행됨 -------");
		System.err.println("제목 : " + subject);
		System.err.println("내용 : " + content);
	}
}