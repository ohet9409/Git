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
	JDialog jDialog = new JDialog(this);		// 팝업창
	public Swing02() {
		// jframe 설정
		this.setTitle("Swing02");
		this.setSize(500, 200);
		this.setLocation(1300, 300);
		setIconImage(imageIcon2.getImage());
		init();
		start();
		setVisible(true);
	}
	private void init() {
		// JFrame 구성
		container.setLayout(new FlowLayout());
		container.add(button1);
		container.add(button2);
		container.add(button3);
		
		// button1 비활성화
		button1.setEnabled(false);
		
		// button2 단축키 지정 (alt + a)
		button2.setMnemonic('a');
		
		// button3 설정
		// Text 위치 지정
		button3.setHorizontalTextPosition(SwingConstants.LEFT);
		button3.setVerticalTextPosition(SwingConstants.TOP);
		// 마우스로 눌렀을 때의 이미지 변화
		button3.setPressedIcon(imageIcon2);
		// 마우스를 올렸을 때의 이미지 변화
		button3.setRolloverIcon(imageIcon3);
	}
	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		button2.addMouseListener(this);
		button3.addMouseListener(this);
		// dialog의 x버튼 종료
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
			jDialog.setTitle("버튼2");
			jDialog.setLocation(1400, 500);
			jDialog.setVisible(true);
		}else if(e.getSource() == button3) {
			
			jDialog.setTitle("버튼3 clicked");
			jDialog.setLocation(1600, 500);
			jDialog.setVisible(true);
		}
		
	}

	@Override 		// 버튼의 마우스를 올려 놓으면 작동
	public void mouseEntered(MouseEvent e) {
		if(e.getSource() == button3) {
			jDialog.setTitle("버튼3 entered");
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
