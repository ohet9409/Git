package exam6;

public class Calc {
	// singleton 패턴 시작
	private static Calc instance = null;

	public static Calc getInstance() {
		if (instance == null)
			instance = new Calc();
		return instance;
	}

	// 기본 생성자를 private으로 하면, new를 통한 객체 생성이 금지된다.
	private Calc() {
	}

	// singleton 패턴 끝
	public void plus(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));

	}

	public void minus(int x, int y) {
		System.out.println(x + " - " + y + " = " + (x - y));

	}

}
