
public class Exam5 {

	public static void main(String[] args) {
		// ������� �Է°�
		String[] src = { "5", "2", "7", "3" };
		// src ������� ���ڷ� ��ȯ�ؼ� ������ �迭
		int[] arr = new int[3];
		try {
			for (int x = 0; x < src.length; x++) {
				arr[x] = Integer.parseInt(src[x]);
				System.out.println(arr[x]);
			}

		} catch (NumberFormatException e) {
			System.out.println("���ڿ��� �����θ� �����Ǿ����� �մϴ�..");
			System.out.println("���� : " + e.getMessage());
//			e.printStackTrace();
//			System.out.println("������ �߻��߽��ϴ�.");

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭�� ũ�Ⱑ �����Ǿ����ϴ�.");
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("�˼����� �����Դϴ�.");
		}
		System.out.println("--- ���α׷��� �����մϴ�. ---");
	}

}
