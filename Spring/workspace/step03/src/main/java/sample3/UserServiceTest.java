package sample3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("sample3/applicationContext.xml");
		// bean 객체 얻어오기 1
		UserService service1 = (UserService) context.getBean("userService");
		UserVo vo = new UserVo("강호동");
		service1.addrUser(vo);
		System.out.println("-----------------------------------------");
		// bean 객체 얻어오기 2
		UserService service2 = context.getBean("userService", UserService.class);
		UserVo vo2 = new UserVo("이순신");
		service2.addrUser(vo2);
	}

}
