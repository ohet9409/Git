import java.util.Calendar;

public class Exam4 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		// 요일수 얻어오기 (일=1 ~ 토=7)
		int dayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("오늘의 요일수 : " + dayNum);		
			
		String[] dayName = {"일","월","화", "수","목","금","토"};
		System.out.println("오늘은" + dayName[dayNum-1]+"요일입니다.");
		// 이번달은 몇일까지 있는가?
		int dayCount = calendar.getActualMaximum(Calendar.DATE);
		System.out.println("이번달은 : " + dayCount + "일 까지 있습니다.");
		// 이번달은 무슨 요일부터 시작하는가?
		calendar.set(Calendar.DAY_OF_MONTH, 1);	// 1일로 세팅
		int firstDayNum = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println("firstdayNum = " +firstDayNum);
		System.out.println("이번달의 시작은 " + dayName[firstDayNum-1]+"요일입니다.");
	}
}
