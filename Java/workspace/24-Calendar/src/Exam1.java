import java.util.Calendar;

public class Exam1 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		// ��, ��, ��, ��, ��, ��
		int yy = calendar.get(calendar.YEAR);
		int mm = calendar.get(calendar.MONTH)+1;
		int dd = calendar.get(calendar.DAY_OF_MONTH);
		int hh = calendar.get(calendar.HOUR_OF_DAY);
		int mi = calendar.get(calendar.MINUTE);
		int ss = calendar.get(calendar.SECOND);
		System.out.printf("%2d��%2d��%2d��%2d��%2d��%2d��\n",yy,mm,dd,hh,mi,ss);
		
		int ampm = calendar.get(calendar.AM_PM); // 0: ����, 1: ����
		String[] apName = {"����","����"};
		
		System.out.printf("%2d��%2d��%2d�� %s %2d��%2d��%2d��\n",yy,mm,dd,apName[ampm],hh,mi,ss);
		
	}

}
