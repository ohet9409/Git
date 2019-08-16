import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class Swing06 extends JFrame implements ActionListener{
	Container container = getContentPane();							// ContentPane�� ������ ����
	JRadioButton radioButtonbutton1 = new JRadioButton("����",true); // true�϶� �⺻ ���õǾ�����
	JRadioButton radioButtonbutton2 = new JRadioButton("����");
	JRadioButton radioButtonbutton3 = new JRadioButton("û�ҳ�");
	JRadioButton radioButtonbutton4 = new JRadioButton("����",true);
	ButtonGroup buttonGroup = new ButtonGroup();		// �׷����� ��� �Ѱ��� ��ư�� ���ð���
	ButtonGroup buttonGroup2 = new ButtonGroup();		// �׷����� ��� �Ѱ��� ��ư�� ���ð���
	public Swing06() {
		// JFrame ����
		setTitle("Swing06");
		setSize(200, 100);
		setLocation(1300, 300);
		
		init();			// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		this.setSize(200, 100);
		this.setLayout(new GridLayout(2,2,5,5));	// 2�� 2�� 5,5 ���μ��� ũ��
		container.add(radioButtonbutton1);			// ȭ�鿡 ��ư �߰�
		container.add(radioButtonbutton2);
		container.add(radioButtonbutton3);
		container.add(radioButtonbutton4);
		
		buttonGroup.add(radioButtonbutton1);		// ��ư �׷쿡 ��ư �߰�
		buttonGroup.add(radioButtonbutton2);
		
		buttonGroup2.add(radioButtonbutton3);
		buttonGroup2.add(radioButtonbutton4);	
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// radioButton �̺�Ʈ ����
		radioButtonbutton1.addActionListener(this);		// ��ư�� �׼� �߰�
		radioButtonbutton2.addActionListener(this);
		radioButtonbutton3.addActionListener(this);
		radioButtonbutton4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButtonbutton1) {
			System.out.println("radioButtonbutton1 = "+radioButtonbutton1.isSelected());
		} else if(e.getSource() == radioButtonbutton2) {
			System.out.println("radioButtonbutton2 = "+radioButtonbutton2.isSelected());
		} else if(e.getSource() == radioButtonbutton3) {
			System.out.println("radioButtonbutton3 = "+radioButtonbutton3.isSelected());
		} else if(e.getSource() == radioButtonbutton4) {
			System.out.println("radioButtonbutton4 = "+radioButtonbutton4.isSelected());
		} 
		
	}
}
public class Exam06 {

	public static void main(String[] args) {
		Swing06 swing06 = new Swing06();

	}

}
