import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Sub11 extends Frame {
	Label label1 = new Label("��� ���");
	Label label2 = new Label("�Է� : ", Label.RIGHT);
	TextArea textArea = new TextArea(); // ������ �Է�, ���(��ũ�� ���O)
	TextField textField = new TextField(); // �� �� �Է�
	Panel panel = new Panel();

	public Sub11() {
		// frame ����
		setTitle("test");
		setSize(300, 300);
		setLocation(1300, 300);
		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);
	}

	private void init() {
		// frame layout ����
		setLayout(new BorderLayout());
		// panel ����
		panel.setLayout(new BorderLayout());
		panel.add("West", label2);
		panel.add("Center", textField);
		// frame ����
		add("North", label1);
		add("Center", textArea);
		add("South", panel);
		// TextArea ���� ����
		textArea.setEditable(false);
	}

	private void start() {
		// frame�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		// textfield �̺�Ʈ ����

//		// ���� ǥ������ �̟G�� �̺�Ʈ ó�� 1
//		textField.addActionListener((ActionEvent e) ->
//		{
//				String str = textField.getText();
//				if (!textArea.getText().equals("")) {
//					str = textArea.getText() + "\n" + str;
//				}
//		
//				textArea.setText(str);
//				// TextArea ������ �� ǥ��
//				textArea.setCaretPosition(textArea.getText().length());
//				textField.setText("");
//			}
//		);
		
		// ���� ǥ������ �̟G�� �̺�Ʈ ó�� 2
		textField.addActionListener((e) -> {							// ��ɾ �������̱� ������ �߰�ȣ �����ȵ�
			String str = textField.getText();
			if (!textArea.getText().equals("")) {
				str = textArea.getText() + "\n" + str;
			}

			textArea.setText(str);
			// TextArea ������ �� ǥ��
			textArea.setCaretPosition(textArea.getText().length());
			textField.setText("");
		});

		// ���� Ŭ������ �̿��� �̺�Ʈ ó��
//		textField.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String str = textField.getText();
//				if (!textArea.getText().equals("")) {
//					str = textArea.getText() + "\n" + str;
//				}
//		
//				textArea.setText(str);
//				// TextArea ������ �� ǥ��
//				textArea.setCaretPosition(textArea.getText().length());
//				textField.setText("");
//				
//			}
//		});
//
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		String str = textField.getText();
//		if (!textArea.getText().equals("")) {
//			str = textArea.getText() + "\n" + str;
//		}
//
//		textArea.setText(str);
//		// TextArea ������ �� ǥ��
//		textArea.setCaretPosition(textArea.getText().length());
//		textField.setText("");
//	}

}

public class Exam11 {

	public static void main(String[] args) {
		Sub11 sub11 = new Sub11();

	}

}
