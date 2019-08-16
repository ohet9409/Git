import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.MouseInputListener;

class Swing02 extends JFrame implements MouseInputListener{
	// this = JFrame
	Container container = this.getContentPane();
	ImageIcon imageIcon1 = new ImageIcon("img/Cat.gif");
	ImageIcon imageIcon2 = new ImageIcon("img/Pig.gif");
	ImageIcon imageIcon3 = new ImageIcon("img/Dog.gif");
	JButton button1 = new JButton("String");
	JButton button2 = new JButton(imageIcon1);
	JButton button3 = new JButton("Str & Icon", imageIcon1);
	JDialog jDialog = new JDialog(this);		// �˾�â
	public Swing02() {
		// jframe ����
		this.setTitle("Swing02");
		this.setSize(500, 200);
		this.setLocation(1300, 300);
		setIconImage(imageIcon2.getImage());
		init();
		start();
		setVisible(true);
	}
	private void init() {
		// JFrame ����
		container.setLayout(new FlowLayout());
		container.add(button1);
		container.add(button2);
		container.add(button3);
		
		// button1 ��Ȱ��ȭ
		button1.setEnabled(false);
		
		// button2 ����Ű ���� (alt + a)
		button2.setMnemonic('a');
		
		// button3 ����
		// Text ��ġ ����
		button3.setHorizontalTextPosition(SwingConstants.LEFT);
		button3.setVerticalTextPosition(SwingConstants.TOP);
		// ���콺�� ������ ���� �̹��� ��ȭ
		button3.setPressedIcon(imageIcon2);
		// ���콺�� �÷��� ���� �̹��� ��ȭ
		button3.setRolloverIcon(imageIcon3);
	}
	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ��ư �̺�Ʈ ����
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		// dialog�� x��ư ����
		jDialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				jDialog.dispose();
			
			}
		});
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == button2){
			jDialog.setTitle("��ư2");
			jDialog.setLocation(1400, 500);
			jDialog.setVisible(true);
		}else if(e.getSource() == button3) {
			
			jDialog.setTitle("��ư3 clicked");
			jDialog.setLocation(1600, 500);
			jDialog.setVisible(true);
		}
		
	}

	@Override 		// ��ư�� ���콺�� �÷� ������ �۵�
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == button3) {
			jDialog.setTitle("��ư3 entered");
			jDialog.setLocation(1600, 500);
			jDialog.setVisible(true);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
}
public class Exam02 {

	public static void main(String[] args) {
		Swing02 swing02 = new Swing02();

	}

}
