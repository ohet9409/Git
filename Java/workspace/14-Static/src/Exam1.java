
public class Exam1 {
	// ������ �������� �ٸ��� ����
	public static void main(String[] args) {
		System.out.println("-- 2000�� --");
		Bank hong = new Bank("ȫ�浿", 10000, 2.5);
		hong.print_account();
		System.out.println("-- 2008�� --");
		Bank kim = new Bank("��ö��", 20000, 4.5);
		hong.print_account();
		kim.print_account();
		System.out.println("-- 2019�� --");
		Bank lee = new Bank("�̿���", 30000, 5.5);
		hong.print_account();
		kim.print_account();
		lee.print_account();
	}
}
