import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

class Swing03 extends JFrame {
	Container container = getContentPane();
	JButton button1 = new JButton("Empty");
	JButton button2 = new JButton("Line");
	JButton button3 = new JButton("Etched");
	JButton button4 = new JButton("Bevel");
	JButton button5 = new JButton("SoftBevel");
	JButton button6 = new JButton("Matte");
	JButton button7 = new JButton("Titled");
	JButton button8 = new JButton("Compound");
	
	
	public Swing03() {
		// JFrame ����
		this.setTitle("Swing03");
		this.setSize(300, 300);
		this.setLocation(1300, 300);
		
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new GridLayout(4,2,3,3));
		container.add(button1);
		container.add(button2);
		container.add(button3);
		container.add(button4);
		container.add(button5);
		container.add(button6);
		container.add(button7);
		container.add(button8);
		// EmptyBorder : Label ó�� ��� ���¸� ������
		button1.setBorder(new EmptyBorder(5,3,5,3));
		// LineBorder : ������Ʈ ������ ������ ǥ���ϴ� ������ ������ �β��� ������ �� �ִ�.
		button2.setBorder(new LineBorder(Color.RED, 3));
		// EtcheBorder : ������Ʈ ������ Ȩ�� �Ŀ� �ִ� ����� ǥ��
		button3.setBorder(new EtchedBorder());
		// BevelBorder : ������Ʈ�� �ö���ų� ������ ����� ǥ��
		button4.setBorder(new BevelBorder(BevelBorder.RAISED));
		// SoftBevelBorder : BevelBorder�� ���
		button5.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		// MatteBorder : �׵θ��� �β��� �����Ͽ�, �����̳� �̹����� ���� �� �ִ�.
		button6.setBorder(new MatteBorder(5,10,15,20,Color.BLUE));
		// TitleBorder : ������Ʈ ������ ������ �ִ� ����.
		button7.setBorder(new TitledBorder("����"));
		// CompoundBorder : �ΰ��� �̻��� ���� ȿ���� ���ÿ� �� �� �ִ�.
		SoftBevelBorder softBevelBorder = new SoftBevelBorder(SoftBevelBorder.RAISED);
		TitledBorder titledBorder = new TitledBorder("����");
		button8.setBorder(new CompoundBorder(softBevelBorder,titledBorder));
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam03 {

	public static void main(String[] args) {
		Swing03 swing03 = new Swing03();

	}

}
