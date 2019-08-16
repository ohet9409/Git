import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.naming.InitialContext;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

class Swing09 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("ID : ",JLabel.RIGHT);
	JTextField textField = new JTextField(10);
	
	JDialog dialog = new JDialog(this,"Ȯ��");
	Container dialogcontainer = dialog.getContentPane(); // ���̾�α׷� ���� ���´�.
	JLabel diJLabel = new JLabel("����� �� �ִ� ID�Դϴ�.",JLabel.CENTER);
	
	public Swing09() {
		// JFrame ����
		setTitle("Swing09");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(label);
		container.add(textField);
		
		dialogcontainer.setLayout(new BorderLayout());
		diJLabel.setBorder(new BevelBorder(BevelBorder.RAISED));	// ���̾�α׿� Ƣ����� ȿ���߰�
		dialogcontainer.add("Center",diJLabel);			// ���̾�α׿� �� �߰�
		dialog.setSize(200,150);
		dialog.setLocation(1400, 400);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// ������ ����
		// dialog x��ư ó�� : �����ɸ� ó���Ѵ�.
		dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);	// â�� �������
		// textField �̺�Ʈ ó��
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);	// �ؽ�Ʈ �ʵ忡 ���͸� ġ�� ���̾�α� â�� �ߵ��� ����
				
			}
		});
	}
}
public class Exam09 {

	public static void main(String[] args) {
		Swing09 swing09 = new Swing09();

	}

}
