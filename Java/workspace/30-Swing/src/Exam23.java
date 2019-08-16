
import java.awt.BorderLayout;
import java.awt.Container;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

class Swing23 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("Test");
	JButton buttonUp = new JButton("�� ��ư");
	JButton buttonDown = new JButton("�Ʒ� ��ư");
	JButton buttonLeft = new JButton("���� ��ư");
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,buttonUp,buttonDown);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,buttonLeft,splitPane);
	
	
	public Swing23() {
		// JFrame ����
		setTitle("Swing23");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",splitPane2);
		// �Ʒ��� ������Ʈ�� �ٸ� ������Ʈ�� ����
		JButton buttonDown1 = new JButton("�Ʒ�1 ��ư");
		splitPane.setBottomComponent(buttonDown1);
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam23 {

	public static void main(String[] args) {
		Swing23 swing = new Swing23();

	}

}
