/**
 * ���α׷� �ҽ��� �ּ� ���� = class ���α׷� ���� Ŭ���� (���� Ŭ����) --> public class Ŭ�����̸� ���� Ŭ���� �̸���
 * �ҽ������� �̸��� �����ؾ� �ϸ�, ����, ����, �����(_)�� ��� �����ϴ�. ù ���ڴ� �ݵ�� ���� �빮�ڷ� �����Ǿ�� �Ѵ�.
 */
public class Exam1 {
	/*
	 * ���α׷��� ������ --> main �Լ�(=�޼ҵ�)
	 */
	public static void main(String[] args) {
		// �ֿܼ� ���ڿ��� ����ϱ� ���� ��ɾ�
		// ���ڿ��� ǥ���ϴ� ��� --> �ֵ���ǥ�� ���´�. => "���ڿ�"
		System.out.println("Hello java"); // ����Ϳ� �����, ���� �ѱ��� ����
		System.out.print("�ڹ�"); // ����Ϳ� �����, ���� �ѱ��� ����
		System.out.println(); // ���� �ѱ�
		// System.out.print(); //print()�� �ݵ�� ����� �����Ͱ� �־�� ��
		System.out.println("���");
		// ���Ĺ���: %d %f %c %s
		// %d: ����
		// %f: �Ǽ�
		// %c: ����
		// %s: ���ڿ�
		// %b: boolean
		// \n: ���๮��(���ٳѱ� ����: Enter ����)
		System.out.printf("%d %f %c %s\n", 5, 7.7, 'A', "ȫ�浿");
		// System.out.printf("%f %d %s %c", 5, 7.7, 'A', "ȫ�浿");

		System.out.println(5);
		System.out.println(5.5);
		System.out.println('A');
		System.out.println("ȫ�浿");
		System.out.println(true);

		System.out.print(5 + " "); // 5���鹮��
		System.out.print(5.5 + " "); // ��� ����
		System.out.print('A' + " ");
		System.out.print("ȫ�浿" + " ");
		System.out.print(true);
	}
}
