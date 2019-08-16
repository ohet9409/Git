import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.beans.PropertyVetoException;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

class Swing13 extends JFrame {
	Container container = getContentPane();
	JPanel panel = new JPanel();
//	public JInternalFrame(String title,
//            boolean resizable,
//            boolean closable,
//            boolean maximizable)
	JInternalFrame internalFrame = new JInternalFrame("제목", true, true, true, true); // 안에 작은 프레임 만들기
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	
	public Swing13() {
		// JFrame 설정
		setTitle("Swing13");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",button1);
		container.add("Center",panel);
		container.add("South",button2);
		// panel 구성
		panel.setLayout(new BorderLayout());
		panel.add("Center",internalFrame);
		// internalFrame 구성
		Container interContainer = internalFrame.getContentPane();
		interContainer.setLayout(new FlowLayout());
		interContainer.add(new JButton("1"));	// 버튼 추가 다른 방식
		interContainer.add(new JButton("2"));
		
		internalFrame.setFrameIcon(new ImageIcon("img/cat.gif"));	// 타이틀 아이콘 변경
		try {
			internalFrame.setMaximum(true);	// 기본적으로 최대 크기로 보여줌 설정
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		internalFrame.setSize(100, 80);
		internalFrame.setVisible(true);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam13 {

	public static void main(String[] args) {
		Swing13 swing = new Swing13();

	}

}
