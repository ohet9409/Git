package exam6;

public class Calc {
	// singleton ���� ����
	private static Calc instance = null;

	public static Calc getInstance() {
		if (instance == null)
			instance = new Calc();
		return instance;
	}

	// �⺻ �����ڸ� private���� �ϸ�, new�� ���� ��ü ������ �����ȴ�.
	private Calc() {
	}

	// singleton ���� ��
	public void plus(int x, int y) {
		System.out.println(x + " + " + y + " = " + (x + y));

	}

	public void minus(int x, int y) {
		System.out.println(x + " - " + y + " = " + (x - y));

	}

}
