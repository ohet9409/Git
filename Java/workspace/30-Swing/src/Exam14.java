import java.awt.Container;
import java.awt.FlowLayout;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JList;

class Swing14 extends JFrame {
	Container container = getContentPane();
	String[] str = {"AAA","BBB","CCC","DDD","EEE"};
	JList<String> list = new JList<String>(str);
	public Swing14() {
		// JFrame ����
		setTitle("Swing14");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(list);
		// ȭ�� ���۽� �ι�° ~�׹�° ����
		list.addSelectionInterval(1, 3);
//		String[] str1 = {"aaa","bbb","ccc"};
//		list.setListData(str1);
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam14 {

	public static void main(String[] args) {
		Swing14 swing = new Swing14();

	}

}
