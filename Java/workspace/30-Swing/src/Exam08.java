import java.awt.Container;
import java.awt.FlowLayout;

import javax.naming.InitialContext;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

class Swing08 extends JFrame {
	Container container = getContentPane();
	JButton[] button = new JButton[6];
	Box box1, box2, box3;
	
	public Swing08() {
		// JFrame ����
		setTitle("Swing08");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		for(int x=0; x<button.length; x++) {
			button[x]=new JButton(String.valueOf(x+1));	//String.valueOf(x+1) --> ���ڿ��� �ٲ� button���� ���ڿ��� �Է� ����
		}
		// ���������� ������Ʈ�� �߰��ϴ� Box ��ü�� ����
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(10));  // ���η� 10�ȼ��� ���� ������ ����
		for(int x=0; x<3; x++) {
			box1.add(button[x]);
			box1.add(Box.createVerticalStrut(10));	// ��ư ���� ������ 10�ȼ� �������� ����
		}
		// ���������� ������Ʈ�� �߰��ϴ� Box ��ü�� ����
		box2 =Box.createHorizontalBox();
		box2.add(Box.createVerticalStrut(170));		// ��ü������ ���� �� ��������
		
		for(int x=3; x<6; x++) {
			box2.add(button[x]);
			box2.add(Box.createHorizontalStrut(10));
		}
		box3 =Box.createHorizontalBox();
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(30));
		box3.add(box2);
		
		container.add(box3);
		
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam08 {

	public static void main(String[] args) {
		Swing08 swing08 = new Swing08();

	}

}
