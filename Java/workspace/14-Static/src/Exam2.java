
public class Exam2 {
	// ��� ���� �������� �����ϴ� ����
	public static void main(String[] args) {
		System.out.println("--- 2000�� ---");
		BankStatic.setRate(2.5);			// ��� ���� �������� 2.5%�� ����
		BankStatic hong = new BankStatic("ȫ�浿", 10000);
		hong.print_account();
		System.out.println("--- 2008�� ---");
		BankStatic.setRate(4.5);			// ��� ���� �������� 4.5%�� ����
		BankStatic kim = new BankStatic("��ö��", 20000);
		hong.print_account();
		kim.print_account();
		
		System.out.println("--- 2019�� ---");
		BankStatic.setRate(5.5);			// ��� ���� �������� 5.5%�� ����
		BankStatic lee = new BankStatic("�̿���", 50000);
		hong.print_account();
		kim.print_account();
		lee.print_account();
	}
}
