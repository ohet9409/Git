import java.util.Calendar;

public class Exam2 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		DataPrinter.printDateTime(calendar);
		// Ư�� ��¥�� ����
		calendar.set(Calendar.YEAR, 2020);
		calendar.set(Calendar.MONDAY, 4);	// 5�� ����
		calendar.set(Calendar.DAY_OF_MONTH, 5);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		DataPrinter.printDateTime(calendar);
		
		calendar.set(2002, 3,15);
		DataPrinter.printDateTime(calendar);
		
		calendar.set(2019, 3,4,18,15,0);
		DataPrinter.printDateTime(calendar);
	}
}
