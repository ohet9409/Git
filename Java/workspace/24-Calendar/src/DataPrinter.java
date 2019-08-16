import java.util.Calendar;

public class DataPrinter {
	public static void printDateTime(Calendar calendar) {
		// 년, 월, 일, 시, 분, 초
		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		int mi = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		System.out.printf("%2d년%2d월%2d일 %2d시%2d분%2d초\n", yy, mm, dd, hh, mi, ss);
	}
}
