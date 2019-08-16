package sample3;
// factory 패턴을 이용해서 의존성 낮추기
public class HelloSpring {
	public static void main(String[] args) {
		// 영어
		BeanFactory beanFactory = new BeanFactory();
		MessageBean bean = beanFactory.getBean("en");
		bean.sayHello();
		// 한글
		bean = beanFactory.getBean("kr");
		bean.sayHello();
	}
}
