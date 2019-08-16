package anno6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 앞의 예제의 bean.xml과 같은 기능을 하는 클래스
@Configuration
public class AppConfig {
	// <bean id="myService" class="anno6.UserServiceImpl"/>
	@Bean
	public UserService myService() {
		return new UserServiceImpl();
	}
}
