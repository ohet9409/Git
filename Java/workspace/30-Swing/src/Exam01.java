import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Swing1 extends JFrame{
	ImageIcon imageIcon = new ImageIcon("img/Cat.gif");	// �̹��� �߰�(���� ������Ʈ ����)
	public Swing1() {
		// jframe ����
		setTitle("Swing1");
		setSize(300, 200);
		// �Ѱ�� ��ġ ����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();	 // ������� ũ�� ����
		Dimension dimension2 = this.getSize();			// ���α׷��� ũ��
		int x = (int) (dimension1.getWidth()/2-dimension2.getWidth()/2);
		int y = (int) (dimension1.getHeight()/2 - dimension2.getHeight()/2);
		setLocation(x, y);
		setIconImage(imageIcon.getImage());
		init();
		start();
		setVisible(true);
	}

	private void init() {
		
		
	}

	private void start() {
		// jframe�� x��ư ���� ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam01 {

	public static void main(String[] args) {
		Swing1 swing1 = new Swing1();

	}

}
