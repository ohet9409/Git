import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class Swing04 extends JFrame {
	Container container = getContentPane();
	JButton button1 = new JButton("Add");
	JButton button2 = new JButton("�λ��");
	JButton button3 = new JButton("�ѹ���");
	JButton button4 = new JButton("�繫��");
	JButton button5 = new JButton("�渮��");
	JButton button6 = new JButton("��ǻ��");
	JButton button7 = new JButton("�ڵ���");
	JButton button8 = new JButton("�� ��");
	JLabel label1 = new JLabel("", JLabel.CENTER);
	JPanel panelN = new JPanel();
	JPanel panelC = new JPanel();
	JPanel panelE = new JPanel();
	JPanel panelS = new JPanel();
	JPanel panelW = new JPanel();
	public Swing04() {
		setLayout(new BorderLayout());
		this.setTitle("Swing04");
		this.setSize(500, 300);
		this.setLocation(1300, 300);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// North ����
		panelN.setBorder(new TitledBorder("Title Label"));
		label1.setText("BorderLayout by ���̾�");
		label1.setFont(new Font("�ü�ü",Font.BOLD,20));
		panelN.add("Center",label1);
		// West ����
//		panelW.setLayout(new FlowLayout());
		
		panelW.setBorder(new TitledBorder("West"));
		panelW.add(button1);
		// Center ����
//		panelC.setLayout(new FlowLayout());
		panelC.setBorder(new TitledBorder("Center"));
		panelC.add(button2);
		panelC.add(button3);
		panelC.add(button4);
		panelC.add(button5);
		// East ����
		panelE.setLayout(new GridLayout(3, 1));
		panelE.setBorder(new TitledBorder("East"));
		panelE.add(button6);
		panelE.add(button7);
		panelE.add(button8);
		// South ����
		panelS.setBorder(new TitledBorder("South"));
		container.setLayout(new BorderLayout());
		container.add("North",panelN);
		container.add("West",panelW);
		container.add("East",panelE);
		container.add("Center",panelC);
		container.add("South",panelS);
		
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam04 {

	public static void main(String[] args) {
		Swing04 swing04 = new Swing04();

	}

}
