
public class Exam3 {

	public static void main(String[] args) {
		// ���ڿ��� ���� ��ȯ
		try {
			// 1. �������� ���
			String year1 = "1994";
			int age1 = 2019 - Integer.parseInt(year1) + 1; // ���ڿ��� ������ ��ȯ
			System.out.println(age1);
			// 2. ���������� ���

			String year2 = "a";
			int age2 = 2019 - Integer.parseInt(year2) + 1;
			System.out.println(age2);
		} catch (Exception e) {
			System.out.println("������ �߻��߽��ϴ�.");
			System.out.println("����: " + e.getMessage());
		}
		System.out.println("--- ���α׷��� �����մϴ�. ---");
	}

}
