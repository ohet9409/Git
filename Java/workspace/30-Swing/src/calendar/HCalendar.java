package calendar;

import java.util.Calendar;

import javax.swing.JButton;
// 날짜 계산
public class HCalendar {
	JButton[] buttons;
	Calendar calendar;
	int year, month;
	
	public HCalendar() {
		calendar= Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;		// 0 -> 1월
	}
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// Label에 출력할 년,월 문자열
	public String getCalText() {
		return year +"년 " + month + "월";
	}
	// 달력을 새로운 년월로 새로 그리기
	public void allInit(int gap) {
		// 버튼의 날짜 지우기
		for(int i =7; i<buttons.length; i++) {
			buttons[i].setText("");
		}
		// 년, 월 수정
		calInput(gap);
		// 버튼에 날짜 출력하기
		calSet();
	}
	// 년,월 수정
	private void calInput(int gap) {
		month += gap;
		if(month <=0) {
			month=12;
			year--;
		} else if(month>=13) {
			month = 1;
			year++;
		}
	}
	// 버튼에 날짜 출력하기
	public void calSet() {
		calendar.set(year,month-1,1);	// 날짜 수정
		// 1일이 시작되는 요일 수 = 요일 수 - 1
		// => 요일 수가 1부터 시작, 배열은 0부터 시작
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK)-1;
		for(int i=1; i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			// buttons[0] ~ [6] : 일~토
			// 그 달의 1일은 buttons[6+(요일수-1) + i]
			buttons[6+firstDay+i].setText(String.valueOf(i));
		}
		
	}
}
