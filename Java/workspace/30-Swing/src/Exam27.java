import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Swing27 extends JFrame {
	Container container = getContentPane();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	CardLayout cardLayout = new CardLayout();	// ȭ�� ��ø ��ġ
	
	public Swing27() {
		// JFrame ����
		setTitle("Swing27");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(cardLayout);
		container.add(panel,"red");
		container.add(panel2,"blue");
		
		panel.setBackground(Color.RED);
		panel2.setBackground(Color.BLUE);
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// panel �̺�Ʈ ó��
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(container, "blue");
			}
		});
		panel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(container, "red");
			}
		});
	}
}
public class Exam27 {

	public static void main(String[] args) {
		Swing27 swing = new Swing27();

	}

}
