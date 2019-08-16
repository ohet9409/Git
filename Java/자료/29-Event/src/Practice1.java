import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class PracFrame1 extends Frame implements ActionListener {
	Button button1 = new Button("Test");
	Button button2 = new Button("Test1");
	Button button3 = new Button("Test2");
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	BorderLayout borderLayout = new BorderLayout();
	GridLayout gridLayout1 = new GridLayout(2, 1);	// 2�� 1��
	GridLayout gridLayout2 = new GridLayout(1, 2);	// 1�� 2��
	
	public PracFrame1() {
		// Flame ����
		setTitle("Panel ����");
		setSize(300, 300);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		
		setVisible(true);
	}
	
	private void init() {
		setLayout(borderLayout); 		// Frame�� Layout ����
		panel1.setLayout(gridLayout1);	// panel1�� Layout ����
		panel2.setLayout(gridLayout2);	// panel2�� Layout ����
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.MAGENTA);
		button3.setBackground(Color.GREEN);
		
		panel1.add(button2);
		panel1.add(button3);
		
		panel2.add(button1);
		panel2.add(panel1);
		
		add("South", panel2);
	}
	private void start() {
		// Frame â�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// ��ư�� �̺�Ʈ ����
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);
		dialog.setLocation(1400, 400);
		
		if(e.getSource() == button1) {
			dialog.setTitle("Test");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("Test1");
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {
			dialog.setTitle("Test2");
			dialog.setVisible(true);
		}
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
			}
		});
	}	
}
public class Practice1 {
	public static void main(String[] args) {
		PracFrame1 pracFrame1 = new PracFrame1();
	}
}


