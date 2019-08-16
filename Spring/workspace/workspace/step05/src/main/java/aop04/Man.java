package aop04;

public class Man implements Person{
	@Override
	public void classWork() {
		System.out.println("컴퓨터를 켜고 Game을 시작한다.");		
		int a = 5/0;
	}	
}






