package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * <bean id = "car" class="anno1.Car">
		<constructor-arg ref="test"/>
	</bean> 와 동일한 설정
 */
@Component
public class Car {
	// Autowired 어노테이션이 붙은 인스턴스 변수는 해당 변수 타입과 일치하는 컨텍스트 내의
	// bean 객체를 찾아 인스턴스 변수에 주입해준다.
	// @Autowired : 멤버 변수(객체) 초기화 명령어
	// 내부적으로 setter를 만들어서 멤버 변수를 초기화 시킴
	@Autowired
	private Tire tire;

	public Car() {
		super();
		System.out.println("Car() 호출");
	}

	public Car(Tire tire) {
		super();
		this.tire = tire;
		System.out.println("Car(Tire tire) 호출");
	}
	
	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire(Tire tire) 호출");
	}

	public void drive() {
		System.out.println(tire.getBrand() + "로 만들어진 국산 자동차");
	}
}
