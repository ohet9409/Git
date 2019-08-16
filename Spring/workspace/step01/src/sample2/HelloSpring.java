package sample2;

public class HelloSpring {
	public static void main(String[] args) {
		// 영어
		MessageBean messageBeanEn = new MessageBeanEn();
		messageBeanEn.sayHello();
		// 한글		
		MessageBean messageBeanKr = new MessageBeanKr();
		messageBeanKr.sayHello();
	}
}
