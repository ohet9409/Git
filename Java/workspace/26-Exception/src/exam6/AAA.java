package exam6;

public class AAA {

	public void ex() throws Exception{	// 예외전가
		// 2. 비정상적인 경우
		String year2 = "뭘까요?";
		int age2 = 2019 - Integer.parseInt(year2) + 1;
		System.out.println(age2);
	}

}
