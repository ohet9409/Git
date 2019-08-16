// 클래스 안의 함수 사용예제
class HelloWord{
	String message;
	
	void setEng() {
		message = "Hello java";
	}
	void setKor() {
		message = "안녕하세요. 자바";
	}
	void sayHello() {
		System.out.println(message);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		HelloWord helloWord = new HelloWord();
		// 메소드 호출
		helloWord.setEng();
		helloWord.sayHello();
		
		helloWord.setKor();
		helloWord.sayHello();
	}
}
