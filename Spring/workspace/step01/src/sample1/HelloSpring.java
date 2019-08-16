package sample1;
// 결합도가 높은 프로그램
public class HelloSpring {
	public static void main(String[] args) {
		// 영어
		MessageBeanEn messageBeanEn = new MessageBeanEn();
		messageBeanEn.sayHello();
		// 한글
		MessageBeanKr messageBeanKr = new MessageBeanKr();
		messageBeanKr.tellMe();
	}
}
