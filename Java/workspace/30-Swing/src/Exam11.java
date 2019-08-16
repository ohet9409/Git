import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing11 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("�޸���",JLabel.CENTER);
	JButton button = new JButton("Ȯ��");
	JButton button2 = new JButton("���");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);	//textArea�� ��ũ�� ��� �߰�
	JPanel panelButton = new JPanel();
	
	
	public Swing11() {
		// JFrame ����
		setTitle("Swing11");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",scrollPane);
		container.add("South",panelButton);
		
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT)); // ��ư �г��� �����ʿ� ��ġ
		panelButton.add(button);
		panelButton.add(button2);
		// textArea ��� ����
		textArea.setDragEnabled(true); // �巡�� ��� Ȱ��ȭ
		textArea.setFocusAccelerator('r');	// textArea�� Ŀ�� �ű�(����Ű ��� alt+r)
		textArea.setSelectedTextColor(Color.RED);	// ���õ� ������ ���� ���� ����
		textArea.setSelectionColor(Color.YELLOW);	// ���õ� ������ ��� ���� ����
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textArea �̺�Ʈ ����
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {	// ���� Ŭ�� �ν�
					textArea.paste(); 	// �ٿ��ֱ� ��� ����
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {	// ������ ���콺 Ű�� �������� �ν�
					textArea.setText("ȫ�浿");
				}
			}
		});
	}
}
public class Exam11 {

	public static void main(String[] args) {
		Swing11 swing11 = new Swing11();

	}

}
