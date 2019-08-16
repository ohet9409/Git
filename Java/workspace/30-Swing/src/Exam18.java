import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Swing18 extends JFrame {
	Container container = getContentPane();
	// ù��° ��
	JLabel label = new JLabel("ID : ", JLabel.RIGHT);
	JTextField textField = new JTextField();
	// �ι�° ��
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	// ����° ��
	JLabel labelpass = new JLabel("Pass : ", label.RIGHT);
	JPasswordField passwordField = new JPasswordField();
	// panel
	JPanel panel1 = new JPanel();
	JPanel panel3 = new JPanel();

	public Swing18() {
		// JFrame ����
		setTitle("Swing18");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", panel1);
		container.add("Center", scrollPane);
		container.add("South", panel3);
		// panel1����
		panel1.setLayout(new BorderLayout());
		panel1.add("West",label);
		panel1.add("Center",textField);
		// textField ��� ����
		textField.setHorizontalAlignment(JTextField.CENTER);
		// panel3 ����
		panel3.setLayout(new BorderLayout());
		panel3.add("West", labelpass);
		panel3.add("Center",passwordField);
		// passwordField ��¹��� ����
		passwordField.setEchoChar('%');
	}

	private void start() {
		// x��ư ���� ó��0
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				String result = passwordField.getText();
				String result = new String(passwordField.getPassword());
				System.out.println("result =" + result );
			}
		});
	}
}

public class Exam18 {

	public static void main(String[] args) {
		Swing18 swing = new Swing18();

	}

}
