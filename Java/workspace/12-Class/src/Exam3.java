// Ŭ���� ���� �Լ� ��뿹��
class HelloWord{
	String message;
	
	void setEng() {
		message = "Hello java";
	}
	void setKor() {
		message = "�ȳ��ϼ���. �ڹ�";
	}
	void sayHello() {
		System.out.println(message);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		HelloWord helloWord = new HelloWord();
		// �޼ҵ� ȣ��
		helloWord.setEng();
		helloWord.sayHello();
		
		helloWord.setKor();
		helloWord.sayHello();
	}
}
