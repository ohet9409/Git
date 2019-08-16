import java.util.Calendar;

public class DataPrinter {
	public static void printDateTime(Calendar calendar) {
		// ��, ��, ��, ��, ��, ��
		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		int mi = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		System.out.printf("%2d��%2d��%2d�� %2d��%2d��%2d��\n", yy, mm, dd, hh, mi, ss);
	}
}
