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

class Event extends Frame implements ActionListener{
	Button button1 = new Button("test");
	Button button2 = new Button("test1");
	Button button3 = new Button("test2");
	BorderLayout borderLayout = new BorderLayout();	// ������ ��(��������)
	GridLayout gridLayout1 = new GridLayout(1,2);	// �гο� (1�� 2��)
	GridLayout gridLayout2 = new GridLayout(2,1);	// �гο� (2�� 1��)
	Panel panel = new Panel();
	Panel panel2 = new Panel();
//	Panel panel = new Panel(new GridLayout(1,2));	// 1�� 2��
//	Panel panel2 = new Panel(new GridLayout(2,1));	// 2�� 1��
	
	public Event() {
		// frame ����
		setTitle("Panel ����");	// ȭ�� ����
		setSize(300, 200);		// ȭ�� ũ��
		setLocation(1300, 300);	// ȭ�� ��ġ
		init();					// ȭ�� ����
		start();				// �̺�Ʈ ����
		setVisible(true);		// ȭ�� ���̱�
	} 
	private void init() {
		setLayout(borderLayout);				// Frame�� Layout ����
		button1.setBackground(Color.YELLOW);	
		button2.setBackground(Color.MAGENTA);
		button3.setBackground(Color.GREEN);
		panel.setLayout(gridLayout1);			// Panel�� Layout ����
		panel2.setLayout(gridLayout2);			// Pane2�� Layout ����
		panel.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel.add(panel2);						// Panel�� Panel2 �߰�(2���� �߰���)
		add("South",panel);						// ���ʿ� panel�� ��ġ ��Ų��.
	}
	private void start() {
		// ��ư�� �̺�Ʈ ����
		button1.addActionListener(this);	// this : actionPerformed �Լ�
		button2.addActionListener(this);
		button3.addActionListener(this);
		// frame â�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {	// ����Ŭ���� ���
			@Override
			public void windowClosing(WindowEvent e) {	// ������ â�ݱ�
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {	// ��ư Ŭ��
		Dialog dialog = new Dialog(this);	// ��ư Ŭ���� â �߱� /  this : ���� ������
		dialog.setLocation(1400, 400);
		if(e.getSource() == button1) {
			dialog.setTitle("Test");
			dialog.setVisible(true);
		}else if(e.getSource() == button2) {
			dialog.setTitle("Test1");
			dialog.setVisible(true);
		}else if(e.getSource() == button3) {
			dialog.setTitle("Test2");
			dialog.setVisible(true);
		} 
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {		// �˾� â �ݱ�
				dialog.dispose();			
				super.windowClosing(e);
			}
		});
	}
	
}
public class Prac1 {

	public static void main(String[] args) {
		Event event = new Event();

	}

}
