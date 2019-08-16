package aop02;

public class Man implements Person{

	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		return "Man 클래스";	
	}

}
