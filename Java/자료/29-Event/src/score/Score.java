package score;
// �������̽� �뵵
// 1. � �Լ��� ��ӹ޴� �ڽ�Ŭ�������� ���������� ����� �ϰ� ���� ��
// 2. ���� ����
public interface Score {
	// �Է�
	public void input(ScoreVO vo);
	public void readFile();		// ���� �о����
	// ����
	public String searchHak(String hak);	// �й� �˻�
	public String searchName(String name);	// �̸� �˻�
	public void descSortTot();	// ���� : ����, ��������
	public void ascSortHak();	// ���� : �й�, ��������
	// ���
	public String printTitle();
	public String print();
	public void writeFile();	// ���� �����ϱ�
	public void pgmEnd();		// ���α׷� ����
}



