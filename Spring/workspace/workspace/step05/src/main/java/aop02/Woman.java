package aop02;

public class Woman  implements Person{
	@Override
	public String classWork() {
		System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");
		return "Woman 클래스";
	}	
}



