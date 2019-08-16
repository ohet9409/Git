package calendar;

import java.util.Calendar;

import javax.swing.JButton;
// ��¥ ���
public class HCalendar {
	JButton[] buttons;
	Calendar calendar;
	int year, month;
	
	public HCalendar() {
		calendar= Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;		// 0 -> 1��
	}
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	// Label�� ����� ��,�� ���ڿ�
	public String getCalText() {
		return year +"�� " + month + "��";
	}
	// �޷��� ���ο� ����� ���� �׸���
	public void allInit(int gap) {
		// ��ư�� ��¥ �����
		for(int i =7; i<buttons.length; i++) {
			buttons[i].setText("");
		}
		// ��, �� ����
		calInput(gap);
		// ��ư�� ��¥ ����ϱ�
		calSet();
	}
	// ��,�� ����
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
	// ��ư�� ��¥ ����ϱ�
	public void calSet() {
		calendar.set(year,month-1,1);	// ��¥ ����
		// 1���� ���۵Ǵ� ���� �� = ���� �� - 1
		// => ���� ���� 1���� ����, �迭�� 0���� ����
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK)-1;
		for(int i=1; i<=calendar.getActualMaximum(Calendar.DATE);i++) {
			// buttons[0] ~ [6] : ��~��
			// �� ���� 1���� buttons[6+(���ϼ�-1) + i]
			buttons[6+firstDay+i].setText(String.valueOf(i));
		}
		
	}
}
