package anno6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.scan("anno6");
		context.refresh();
		
		UserService userService = context.getBean(UserService.class);
		userService.show();
		
		context.close();
	}
}
