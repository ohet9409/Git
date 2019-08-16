package study.java.bbs;

public class Article {
	// static ���� : ��� ��ü�� �������� ���
	private static int count = 0;	// ��ü �Խù� �� ����	
	private static String category;	// �Խù� �з� ����
	private int num;		// �� ��ȣ
	private String title;	// �� ����
	private String regData;	// �ۼ��Ͻ�
	/**
	 * ������ : ������� �ʱ�ȭ
	 * @param num : �� ��ȣ
	 * @param title : �� ����
	 * @param regData : �ۼ��Ͻ�
	 */
	public Article(int num, String title, String regData) {
		super();
		this.num = num;
		this.title = title;
		this.regData = regData;
		count++;	// �Խù� �űԵ�� �� 
	}
	/**
	 * ��� ������� ���� Ȯ��
	 */
	@Override
	public String toString() {
		return "�ۺз�=" + category + ", ��ü �� �� = " + count + ", Article [num=" + num + ", title=" + title + ", regData=" + regData + "]";
	}

	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Article.count = count;
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		Article.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegData() {
		return regData;
	}
	public void setRegData(String regData) {
		this.regData = regData;
	}
	
}
