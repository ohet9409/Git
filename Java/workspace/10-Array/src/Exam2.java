
public class Exam2 {
	public static void main(String[] args) {
		/** ���� ó���� ���� 2���� �迭 ���� */
		// �б� ������ ���� �迭
		int[][] grade = new int[3][3];
		String[] name = { "ȫ�浿", "��ö��", "�̿���" };

		// ȫ�浿�� ���� ����
		grade[0][0] = 75;
		grade[0][1] = 82;
		grade[0][2] = 95;
		// ��ö���� ���� ����
		grade[1][0] = 88;
		grade[1][1] = 64;
		grade[1][2] = 70;
		// �̿����� ���� ����
		grade[2][0] = 100;
		grade[2][1] = 95;
		grade[2][2] = 90;
		/** 2���� �迭�� Ž���Ͽ� ������ ������� ���ϱ� */
		for (int x = 0; x < grade.length; x++) { // ���� ����
			int sum = 0;
			double avg = 0;
			for (int y = 0; y < grade[x].length; y++) { // ���� ����
				sum += grade[x][y];
			}
			avg = (double) sum / grade[x].length;
			System.out.println(name[x] + ", ����= " + sum + ", ���= " + avg);
		}
	}
}
