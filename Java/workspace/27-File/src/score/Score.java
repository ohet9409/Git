package score;



// �������̽� �뵵
// 1. � �Լ��� ��ӹ޴� �ڽ�Ŭ�������� ���������� ����� �ϰ� ���� ��
// 2. ���� ����
public interface Score {
	// �Է�
	public void input();
	public void readFile();		// ���� �о����
	// ����
	public void searchHak();	// �й� �˻�
	public void searchName();	// �̸� �˻�
	public void descSortTot();	// ���� : ����, ��������
	public void ascSortHak();	// ���� : �й�, ��������
	
	// ���
	public void printTitle();
	public void print();
	public void writeFile();	// ���� �����ϱ�
	public void pgmEnd();		// ���α׷� ����
	
	
}
