import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

class Swing19 extends JFrame {
	Container container = getContentPane();
	// ���η� ��ġ�Ǵ� ���� ��ü ����
	JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
	JButton button1 = new JButton(new ImageIcon("img/img1.png"));
	JButton button2 = new JButton(new ImageIcon("img/img2.png"));
	public Swing19() {
		// JFrame ����
		setTitle("Swing19");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",toolBar);
		// toolbar ����
		toolBar.setRollover(true);  // ���콺�� �÷��� �� Ȱ��ȭ
		toolBar.add(button1);
		toolBar.addSeparator(new Dimension(20,30));		// �� ��ư ������ ���� ����
		toolBar.add(button2);
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam19 {

	public static void main(String[] args) {
		Swing19 swing = new Swing19();

	}

}
