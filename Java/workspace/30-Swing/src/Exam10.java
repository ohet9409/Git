
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class Swing10 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton button = new JButton("�� ����");
	JButton button2 = new JButton("���� ����");
	JColorChooser colorChooser = new JColorChooser();
	JFileChooser fileChooser = new JFileChooser();

	public Swing10() {
		// JFrame ����
		setTitle("Swing10");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);

	}

	// colorChooser ���� �� ����
	private void color() {
		Color cc = colorChooser.showDialog(this, "���� ���� ����", Color.black);
//		Color cc = colorChooser.show(true);
		System.out.println("���õ� ���� = " + cc);
		colorChooser.setColor(cc); // �⺻ ���� ������ �α�
		System.out.println("�ٽ� ������ = " + colorChooser.getColor());
	}

	// fileChooser ���� �� ����
	private void file() {
		fileChooser.setDialogTitle("�ҷ�����"); // ���̾�α� Ÿ��Ʋ ���� �ٲٱ�
		fileChooser.setMultiSelectionEnabled(true); // ���� ���� �����ϰ� ����
		fileChooser.showDialog(this, "����");
//		File file = fileChooser.getSelectedFile();	// ���� 1�� ó��
		File[] files = fileChooser.getSelectedFiles();	// ���� ������ ó��
		for (int x = 0; x < files.length; x++) {
			System.out.println("���ϸ� = " + files);
		}

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(button);
		container.add(button2);

	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		button.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			color();
		} else if (e.getSource() == button2) {
			file();
		}

	}
}

public class Exam10 {

	public static void main(String[] args) {
		Swing10 swing10 = new Swing10();

	}

}
