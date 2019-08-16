import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.naming.InitialContext;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

class Swing07 extends JFrame {
	Container container = getContentPane();
	// �޴��� �����
	JMenuBar menuBar = new JMenuBar();
	// ���� �޴� �����
	JMenu menuFile = new JMenu("����");
	JMenuItem fNew = new JMenuItem("������");			// ���� �޴��� �ؽ�Ʈ�� �߰�
	ImageIcon img1 = new ImageIcon("img/cat.gif");
	JMenuItem fOpen =new JMenuItem(img1);			// ���� �޴��� �̹����� �߰�
	ImageIcon img2 = new ImageIcon("img/dog.gif");
	JMenuItem fExit = new JMenuItem("����",img2);		// ���� �޴��� �̹���, �ؽ�Ʈ �߰�
	// ���� �޴� �����
	JMenu menuEdit = new JMenu("����");
	JMenu menuEditSize = new JMenu("ũ��");	// ���� �޴��ȿ� ũ���� �޴��� �����ϱ� ����
	JRadioButtonMenuItem es10 = new JRadioButtonMenuItem("10"); // ũ�⸦ ������ ��ư ����
	JRadioButtonMenuItem es20 = new JRadioButtonMenuItem("20");
	JRadioButtonMenuItem es30 = new JRadioButtonMenuItem("30");
	ButtonGroup buttonGroup = new ButtonGroup();	// �׷����� ���´�
	JMenu menuEditColor = new JMenu("����");	// ���� �޴��ȿ� �����̶�� �޴��� �����ϱ� ����
	JCheckBoxMenuItem ecRed = new JCheckBoxMenuItem("Red");
	JCheckBoxMenuItem ecGreen = new JCheckBoxMenuItem("Green");
	JCheckBoxMenuItem ecBlue = new JCheckBoxMenuItem("Blue");
	// ���� �޴� �����
	JMenu menu = new JMenu("����");
	public Swing07() {
		// JFrame ����
		setTitle("Swing07");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		this.setJMenuBar(menuBar); // �����ӿ� �޴��� �߰�
		fExit.setArmed(true);		// �ش� �޴��� ������ ��, �ڵ����� ���õǴ� ��ġ�� ����(���ᰡ �ڵ����õǾ�����)
		menuFile.add(fNew);
		menuFile.addSeparator();	// �޴� ������ ���� ���� ǥ��
		menuFile.add(fOpen);
		menuFile.addSeparator();
		menuFile.add(fExit);
		menuBar.add(menuFile);		// �޴��ٿ� ���� �޴� �߰�
		
		menuEdit.setBorder(new LineBorder(Color.RED,3));	// ���� �޴� �׵θ��� ������, 3ũ���� �� ����
		menuEditSize.setBorder(new BevelBorder(BevelBorder.RAISED));	// ��ư�� Ƣ����� ȿ��
		menuEditColor.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonGroup.add(es10);		// ũ���ư�� �̱����̽��� ����� ���Ͽ� �׷����� ����
		buttonGroup.add(es20);
		buttonGroup.add(es30);
		
		menuEditSize.add(es10);	// ũ�� ��ư�� ���� ��ư item �߰�
		menuEditSize.add(es20);
		menuEditSize.add(es30);
		menuEdit.add(menuEditSize);	// ���� �޴��� ũ������ �޴� �߰�
		menuEdit.addSeparator();
		
		menuEditColor.add(ecRed);	// ���� �޴��� checkBox ������ �߰� (������ ���ð���)
		menuEditColor.add(ecGreen);
		menuEditColor.add(ecBlue);
		menuEdit.add(menuEditColor);	// ���� �޴��� ����޴� �߰�
		
		menuBar.add(menuEdit);	// �޴��ٿ� ���� �޴� �߰� 
		menuBar.add(menu);		// �޴��ٿ� ���� �޴� �߰� 
		
		
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam07 {

	public static void main(String[] args) {
		Swing07 swing07 = new Swing07();

	}

}
