
public class Test {
	      // ����ڷ���(=���ϰ��� �ڷ���) : ��ǻ�Ϳ��� ���ϰ��� �ڷ����� �˷��ִ� ��   /* ���ϰ��� ������ void
	static int plus(int a, int b) {	//�Ű����� : �ٸ� �Լ����� ���޵� ���� �����ϴ� ����
		return a + b;	// �ǵ��� ���� : ȣ��� ������, �� ��� �ǵ��� ����
	}         //�����(= ���ϰ�) 	����, ������� ������, �� ���� ������ �ǵ��ư���.
	static void output(int cc) {
		System.out.println(cc);
	}
	public static void main(String[] args) {
		// ����
		int c;
		// �Է�
		// ����
		c = plus(3,4);		// �Լ��� ȣ�� : �Լ��� ����
		// ���
		output(c);
		return;	// ������ ���� ���ϰ� ���� return�� ���� ������.
	}
}
