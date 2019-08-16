import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;
 
import java.awt.event.WindowListener;

class BaseForm extends Frame implements ActionListener{
	Button button1 = new Button("��ư1");
	Button button2 = new Button("��ư2");
	Button button3 = new Button("��ư3");
	// ������Ʈ : ȭ���� �ٸ��ִ� Ŭ����
	// FlowLayout : ������Ʈ�� ���ʿ��� ���������� ��ġ 
	FlowLayout flowLayout = new FlowLayout();
	// GridLayout : ������Ʈ�� �࿭�� ��ġ
	// public GridLayout(int rows,
//    					int cols,
//    					int hgap,
//    					int vgap)
	GridLayout gridLayout = new GridLayout(2,2,5,50);
	// BorderLayout : ������Ʈ�� ������������ ��ġ
	BorderLayout borderLayout = new BorderLayout();
	
	public BaseForm() {
		// frame ����
		setTitle("Layout Manager");
		setSize(300,200);
		setLocation(1300, 300);		// ����� ���� ��ġ
		
		init1();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		setVisible(true);
	}
	// ȭ�� ���� : FlowLayout, GridLayout, 
	private void init() {
//		setLayout(flowLayout);
		setLayout(gridLayout);
//		setLayout(borderLayout);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.green);
		button3.setBackground(Color.CYAN);
		add(button1);
		add(button2);
		add(button3);
		
	}
	// ȭ�� ���� : BorderLayout
	private void init1() {
//		setLayout(flowLayout);
//		setLayout(gridLayout);
		setLayout(borderLayout);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.green);
		button3.setBackground(Color.CYAN);
//		add("North",button1);
		add("West",button1);
		add("Center",button2);
//		add("South",button3);
		add("East", button3);
		
	}
	// �̺�Ʈ ����
	private void start() {
		// ��ư�� ������ ���� ó��
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		// ������ ���� x��ư�� ���� ó��
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);		// �μ� Ŭ�����̹Ƿ� this(�θ�Ŭ����)�� ����� �Ѵ�. 
		dialog.setLocation(1400,400);
		if(e.getSource() == button1) {
			dialog.setTitle("��ư1");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("��ư2");
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {
			dialog.setTitle("��ư3");
			dialog.setVisible(true);
		} 
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose(); 		// Dialog â �ݱ�
				super.windowClosing(e);
			}
		});
		
	}
	
}
public class Exam5 {

	public static void main(String[] args) {
		BaseForm baseForm = new BaseForm();

	}

}
