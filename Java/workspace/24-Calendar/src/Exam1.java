import java.util.Calendar;

public class Exam1 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		// 년, 월, 일, 시, 분, 초
		int yy = calendar.get(calendar.YEAR);
		int mm = calendar.get(calendar.MONTH)+1;
		int dd = calendar.get(calendar.DAY_OF_MONTH);
		int hh = calendar.get(calendar.HOUR_OF_DAY);
		int mi = calendar.get(calendar.MINUTE);
		int ss = calendar.get(calendar.SECOND);
		System.out.printf("%2d년%2d월%2d일%2d시%2d분%2d초\n",yy,mm,dd,hh,mi,ss);
		
		int ampm = calendar.get(calendar.AM_PM); // 0: 오전, 1: 오후
		String[] apName = {"오전","오후"};
		
		System.out.printf("%2d년%2d월%2d일 %s %2d시%2d분%2d초\n",yy,mm,dd,apName[ampm],hh,mi,ss);
		
	}

}
