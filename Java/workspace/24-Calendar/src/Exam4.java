import java.util.Calendar;

public class Exam4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		// ���ϼ� ������ (��=1 ~ ��=7)
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("������ ���ϼ� : " + dayNum);		
			
		String[] dayName = {"��","��","ȭ", "��","��","��","��"};
		System.out.println("������" + dayName[dayNum-1]+"�����Դϴ�.");
		// �̹����� ���ϱ��� �ִ°�?
		int dayCount = calendar.getActualMaximum(Calendar.DATE);
		System.out.println("�̹����� : " + dayCount + "�� ���� �ֽ��ϴ�.");
		// �̹����� ���� ���Ϻ��� �����ϴ°�?
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 1�Ϸ� ����
		int firstDayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("firstdayNum = " +firstDayNum);
		System.out.println("�̹����� ������ " + dayName[firstDayNum-1]+"�����Դϴ�.");
	}
}
