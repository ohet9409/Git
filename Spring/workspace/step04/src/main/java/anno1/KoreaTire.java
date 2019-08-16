package anno1;

import org.springframework.stereotype.Component;

//@Component("test") : <bean id = "test" class="anno1.KoreaTire"/>
//@Component : default id는 "koreaTire"임
@Component("test")
public class KoreaTire implements Tire{

	@Override
	public String getBrand() {
		return "한국타이어";
	}

}
