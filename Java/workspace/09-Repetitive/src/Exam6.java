
public class Exam6 {
	/** ���� ���: ������ ���� ����� => Math Ŭ���� ���
	 * 	Math.random() �޼ҵ�� 0~1 ������ ���� double���� ���� �����.
	 * 	�̸� �̿��ϸ� Ư�� ������ ������ ���Ƿ� ���� �� �ִ�.
	 */
	public static void main(String[] args) {
		// 10~99������ ������ ���� �����
		double r = Math.random();
		int startNum =10;
		int endNum =99;
		int result=0;
		
		result = (int)(r*(endNum - startNum +1)+startNum);
		System.out.println("r = "+r);
		System.out.println("result = "+result);
	}
}
