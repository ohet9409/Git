package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

// 스프링을 이용해서 의존성 낮추기
public class HelloSpring {
	public static void main(String[] args) {
		//	1. 스프링 컨테이너 구동
		//	=> bean.xml에 정의한 <bean> 설정 정보를 읽어와서
		// 	       내부적으로  MessageBean 객체를 생성하고 초기화한다.
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample4/bean.xml");
		// 	2. Bean객체를 검색하고, MessageBean 객체를 찾아서 리턴
		// 영어
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		
		// 한글
		MessageBean bean2 = (MessageBean) context.getBean("messageBeanK");
		bean2.sayHello();
		
		//	3. 스프링 컨테이너 종료
		context.close();
	}
}
