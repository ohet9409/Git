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
	String[] dayNames = { "��", "��", "ȭ", "��", "��", "��", "��" };
	// Calendar ���� Ŭ����
	HCalendar hCalendar = new HCalendar();

	public Swing28() {
		// JFrame ����
		setTitle("���� �޷�");
		setSize(550, 400);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panel);
		container.add("Center", panel2);
		// panel ����
		buttonAf.setFont(new Font("SanSerif", 1, 20));
		buttonBe.setFont(new Font("SanSerif", 1, 20));
		label.setFont(new Font("SanSerif", 1, 20));
		label.setText(hCalendar.getCalText());

		panel.setLayout(new FlowLayout());
		panel.add(buttonBe);
		panel.add(label);
		panel.add(buttonAf);
		// panel2 ����
		panel2.setLayout(new GridLayout(7, 7, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			panel2.add(buttons[i]);

			// ��ư ��Ʈ ����
			buttons[i].setFont(new Font("Sherif", Font.BOLD, 24));
			// buttons[0]~[6] : �� ~ �� �۾� �ֱ�
			if (i < 7) {
				buttons[i].setText(dayNames[i]);
			}
			// ��ư �� ���� : �� -> ������, �� -> �Ķ���
			if (i % 7 == 0) { // �Ͽ���
				buttons[i].setForeground(Color.RED);
			}
			if (i % 7 == 6) { // �����
				buttons[i].setForeground(Color.BLUE);
			}
		}
		// ��¥ ���
		hCalendar.setButtons(buttons);
		hCalendar.calSet();
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonBe.addActionListener(this);
		buttonAf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBe) {			// 1�� ��
			hCalendar.allInit(-1);
			label.setText(hCalendar.getCalText());
		} else if(e.getSource() == buttonAf) {	// 1�� ��
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
