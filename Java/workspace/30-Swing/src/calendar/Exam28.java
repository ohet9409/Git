package calendar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Swing28 extends JFrame implements ActionListener{
	Container container = getContentPane();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();

	JButton buttonBe = new JButton("Before");
	JButton buttonAf = new JButton("After");
	JLabel label = new JLabel();

	JButton[] buttons = new JButton[49];
	String[] dayNames = { "일", "월", "화", "수", "목", "금", "토" };
	// Calendar 관리 클래스
	HCalendar hCalendar = new HCalendar();

	public Swing28() {
		// JFrame 설정
		setTitle("만년 달력");
		setSize(550, 400);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panel);
		container.add("Center", panel2);
		// panel 구성
		buttonAf.setFont(new Font("SanSerif", 1, 20));
		buttonBe.setFont(new Font("SanSerif", 1, 20));
		label.setFont(new Font("SanSerif", 1, 20));
		label.setText(hCalendar.getCalText());

		panel.setLayout(new FlowLayout());
		panel.add(buttonBe);
		panel.add(label);
		panel.add(buttonAf);
		// panel2 구성
		panel2.setLayout(new GridLayout(7, 7, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			panel2.add(buttons[i]);

			// 버튼 폰트 설정
			buttons[i].setFont(new Font("Sherif", Font.BOLD, 24));
			// buttons[0]~[6] : 일 ~ 토 글씨 넣기
			if (i < 7) {
				buttons[i].setText(dayNames[i]);
			}
			// 버튼 색 설정 : 일 -> 빨간색, 토 -> 파란색
			if (i % 7 == 0) { // 일요일
				buttons[i].setForeground(Color.RED);
			}
			if (i % 7 == 6) { // 토요일
				buttons[i].setForeground(Color.BLUE);
			}
		}
		// 날짜 출력
		hCalendar.setButtons(buttons);
		hCalendar.calSet();
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonBe.addActionListener(this);
		buttonAf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBe) {			// 1달 전
			hCalendar.allInit(-1);
			label.setText(hCalendar.getCalText());
		} else if(e.getSource() == buttonAf) {	// 1달 후
			hCalendar.allInit(+1);
			label.setText(hCalendar.getCalText());
		}
		
	}
}

public class Exam28 {

	public static void main(String[] args) {
		Swing28 swing = new Swing28();

	}

}
