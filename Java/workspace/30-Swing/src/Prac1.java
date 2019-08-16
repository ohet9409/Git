import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class Swing extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("��������");
	JLabel label2 = new JLabel("�̸�: ",JLabel.RIGHT);
	JLabel label3 = new JLabel("�ֹι�ȣ: ",JLabel.LEFT);
	JLabel label4 = new JLabel("��ȭ��ȣ: ",JLabel.RIGHT);
	JLabel label5 = new JLabel("�ּ�: ",JLabel.RIGHT);
	JLabel label6 = new JLabel("�����˻�",JLabel.RIGHT);
	JLabel label7 = new JLabel("�˻�: ",JLabel.LEFT);
	
	JTextField textField = new JTextField();
	JTextField textField2 = new JTextField();
	JTextField textField3 = new JTextField();
	JTextField textField4 = new JTextField();
	JTextField textField5 = new JTextField();
	JTextField textField6 = new JTextField();
	JTextField textField7 = new JTextField();
	
	JTextArea textArea = new JTextArea();
	
	
	
	JButton button4 = new JButton("�˻�");
	JButton button = new JButton("<<");
	JButton button2 = new JButton(">>");
	
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_1_1 = new JPanel();
	JPanel panel_1_2 = new JPanel();
	JPanel panel_1_3 = new JPanel();
	JPanel panel_1_4 = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel panel_2_1 = new JPanel();
	JPanel panel_2_2 = new JPanel();
	
	JPanel panel2 = new JPanel();
	JLabel label8 = new JLabel("��������ȭ��");
	JButton button3 = new JButton("��ü����");
	JLabel label9 = new JLabel("<--�̰��� ������ ��ü���Ⱑ �˴ϴ�.");
	JTextArea textArea2 = new JTextArea();
	JButton button2_1 =new JButton("���");
	JButton button2_2 =new JButton("����");
	JButton button2_3 =new JButton("����");
	JButton button2_4 =new JButton("Clear");
	JButton button2_5 =new JButton("����");
	JButton button2_6 =new JButton("�ε�");
	JButton button2_7 =new JButton("����");
	JPanel panel2_1 = new JPanel();
	JPanel panel2_2 = new JPanel();
	public Swing() {
		// JFrame ����
		setTitle("Swing");
		setSize(800, 500);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",panel);
		
		panel_1_1.setLayout(new GridLayout(4,1));	// ��������
		panel_1_1.add(label2);						// �̸�
		panel_1_1.add(label3);
		panel_1_1.add(label4);
		panel_1_1.add(label5);
		
		panel_1_3.setLayout(new GridLayout(1,2,5,5));
		panel_1_3.add(textField5);
		panel_1_3.add(textField6);
		
		panel_1_2.setLayout(new GridLayout(4,2));	// ��������
		panel_1_2.add(textField);					// �̸�
		panel_1_2.add(panel_1_3);					// �ֹι�ȣ
		panel_1_2.add(textField3);					// ��ȭ��ȣ
		panel_1_2.add(textField4);					// �ּ�
		
		
		
		
//		panel_1_2.setLayout(new GridLayout());
//		panel_1_1.setLayout(new FlowLayout(10));
//		panel_1_1.add("West",label2);
//		panel_1_1.add(textField);
//		
//		panel_1_2.setLayout(new FlowLayout(10));
//		panel_1_2.add(label3);
//		panel_1_2.add(textField2);
//		panel_1_2.add(textField3);
		
//		panel_1_3.setLayout(new FlowLayout(10));
//		panel_1_3.add("West",label4);
//		panel_1_3.add(textField4);
		
//		panel_1_4.setLayout(new FlowLayout(10));
//		panel_1_4.add(label5);
//		panel_1_4.add(textField5);
		
		panel_1.setLayout(new BorderLayout());
		panel_1.add("West",panel_1_1);
		panel_1.add("Center",panel_1_2);
//		panel_1.add(panel_1_3);
//		panel_1.add(panel_1_4);
		
		panel_2_1.setLayout(new GridLayout(1,4));
		panel_2_1.add(label7);
		panel_2_1.add(textField6);
		panel_2_1.add(textField7);
		panel_2_1.add(button4);
		
		panel_2_2.setLayout(new FlowLayout());
		panel_2_2.add(button);
		panel_2_2.add(button2);
		
			
		panel_2.setLayout(new BorderLayout());
		panel_2.add("North",panel_2_1);
		panel_2.add("Center",textArea);
		panel_2.add("South",panel_2_2);
		
		panel2.setLayout(new BorderLayout());
		panel2.add("North",panel2_1);
		panel2.add("Center",textArea2);
		panel2.add("South",panel2_2);
		
		panel2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_1.add(button3);
		panel2_1.add(label9);
		
		panel2_2.setLayout(new GridLayout(1,7));
		panel2_2.add(button2_1);
		panel2_2.add(button2_2);
		panel2_2.add(button2_3);
		panel2_2.add(button2_4);
		panel2_2.add(button2_5);
		panel2_2.add(button2_6);
		panel2_2.add(button2_7);
		
		container.add(panel2);
//		panel2.add(panel2_1);
//		panel2.add(textArea2);
//		panel2.add(panel2_2);
		panel2.setBorder(new TitledBorder("��������ȭ��"));
		panel.setLayout(new GridLayout(2,1));
		panel_1.setBorder(new TitledBorder("��������"));
		panel_2.setBorder(new TitledBorder("�����˻�"));
		panel.add(panel_1);
		panel.add(panel_2);
		
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Prac1 {

	public static void main(String[] args) {
		Swing swing = new Swing();

	}

}
