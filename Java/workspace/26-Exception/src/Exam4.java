
public class Exam4 {
	public static void main(String[] args) {

		int[] arr = new int[3];
		try {
			for (int x = 0; x <= 3; x++) {
				arr[x] = x;
				System.out.println(arr[x]);
			}
		} catch (Exception e) {
			System.out.println("������ �߻��߽��ϴ�.");
			System.out.println("���� : " + e.getMessage());
		}
		finally {
			System.out.println("������ �����, ������ �ʵ� ������ ��ɾ�");
		}
		System.out.println("--- ���α׷��� �����մϴ�. ---");

	}
}
