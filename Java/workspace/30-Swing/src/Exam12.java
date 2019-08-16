import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.swing.JComboBox;
import javax.swing.JFrame;

class Swing12 extends JFrame {
	Container container = getContentPane();
	String[] str = {"AAA","BBB","CCC","DDD","EEE"};
	JComboBox<String> comboBox = new JComboBox<String>(str);	// ������� ���ڿ��� �޺��ڽ��� �߰�
	
	
	public Swing12() {
		// JFrame ����
		setTitle("Swing12");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(comboBox);
		// comboBox�� �׸� �߰�
		comboBox.addItem("FFF");	// �޺��ڽ� ��Ͽ� FFF�߰�
		// comboBox�� ���� ����
		comboBox.setEditable(true);
		// comboBox�� ���� �ִ� ���� ����
		comboBox.setMaximumRowCount(3);	// 3���� ������
		
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// comboBox �̺�Ʈ ó��
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem());
				
			}
		});
		
		
	}
}
public class Exam12 {

	public static void main(String[] args) {
		Swing12 swing = new Swing12();

	}

}
