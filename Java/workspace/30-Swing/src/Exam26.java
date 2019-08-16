import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;

class Swing26 extends JFrame implements ActionListener{
	Container container = getContentPane();
	JButton button = new JButton("��ư1");
	JButton button2 = new JButton("��ư2");
	public Swing26() {
		// JFrame ����
		setTitle("Swing");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center",button);
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ��ư �̺�Ʈ ����
		button.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			container.remove(button);	// ���ֱ�
			container.invalidate();     // ��ȿȭ
			container.add("Center",button2);	// �߰�
			container.validate(); 		// ��ȿȭ
			container.repaint();  		// ȭ�� ����
		} else if(e.getSource() == button2) {
			container.remove(button2);	// ���ֱ�
			container.invalidate();     // ��ȿȭ
			container.add("Center",button);	// �߰�
			container.validate(); 		// ��ȿȭ
			container.repaint();  		// ȭ�� ����
		}
		
	}
}
public class Exam26 {

	public static void main(String[] args) {
		Swing26 swing = new Swing26();

	}

}
