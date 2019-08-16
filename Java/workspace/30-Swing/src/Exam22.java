
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class Swing22 extends JFrame implements ActionListener, Runnable {
	Container container = getContentPane();
	JLabel label = new JLabel("Progress Bar");
	JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100); // ����, 0~100����
	JButton buttonStart = new JButton("����");
	JButton buttonEnd = new JButton("����");

	JPanel panel = new JPanel();
	// ���� ���� ���� ����
	boolean progress = true;
	int num = 0; // 0 ~ 100

	public Swing22() {
		// JFrame ����
		setTitle("Swing");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", progressBar);
		container.add("South", panel);
		// progressBar ����
		progressBar.setStringPainted(true);
		progressBar.setString("0%");
		// panel ����
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(buttonStart);
		panel.add(buttonEnd);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttonStart.addActionListener(this);
		buttonEnd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonStart) {
			progress = true; // ������ ����
			new Thread(this).start();
			buttonStart.setEnabled(false);
			buttonEnd.setEnabled(true);
		} else if (e.getSource() == buttonEnd) {
			progress = false;	// ���� ����
			buttonStart.setEnabled(true);
			buttonEnd.setEnabled(false);
		}

	}

	@Override
	public void run() {
		if(num == 100) num =0;
		for(int i=num;i<=100;i++) {
			if(!progress) break;
			try {
				Thread.sleep(50);	// 50 msec ����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			num=i;
			progressBar.setValue(i);
			progressBar.setString(i+"%");
		}
		// 100%�� �� ���� ���
		buttonStart.setEnabled(true);
		buttonEnd.setEnabled(false);
	}
	
}

public class Exam22 {

	public static void main(String[] args) {
		Swing22 swing = new Swing22();

	}

}
