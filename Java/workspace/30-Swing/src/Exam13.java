import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

class Swing13 extends JFrame {
	Container container = getContentPane();
	JPanel panel = new JPanel();
//	public JInternalFrame(String title,
//            boolean resizable,
//            boolean closable,
//            boolean maximizable)
	JInternalFrame internalFrame = new JInternalFrame("����", true, true, true, true); // �ȿ� ���� ������ �����
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	
	public Swing13() {
		// JFrame ����
		setTitle("Swing13");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",button1);
		container.add("Center",panel);
		container.add("South",button2);
		// panel ����
		panel.setLayout(new BorderLayout());
		panel.add("Center",internalFrame);
		// internalFrame ����
		Container interContainer = internalFrame.getContentPane();
		interContainer.setLayout(new FlowLayout());
		interContainer.add(new JButton("1"));	// ��ư �߰� �ٸ� ���
		interContainer.add(new JButton("2"));
		
		internalFrame.setFrameIcon(new ImageIcon("img/cat.gif"));	// Ÿ��Ʋ ������ ����
		try {
			internalFrame.setMaximum(true);	// �⺻������ �ִ� ũ��� ������ ����
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		internalFrame.setSize(100, 80);
		internalFrame.setVisible(true);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam13 {

	public static void main(String[] args) {
		Swing13 swing = new Swing13();

	}

}
