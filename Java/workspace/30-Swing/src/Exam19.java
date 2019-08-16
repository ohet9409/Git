import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;

class Swing19 extends JFrame {
	Container container = getContentPane();
	// 가로로 배치되는 툴바 객체 생성
	JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);
	JButton button1 = new JButton(new ImageIcon("img/img1.png"));
	JButton button2 = new JButton(new ImageIcon("img/img2.png"));
	public Swing19() {
		// JFrame 설정
		setTitle("Swing19");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",toolBar);
		// toolbar 구성
		toolBar.setRollover(true);  // 마우스를 올렸을 때 활성화
		toolBar.add(button1);
		toolBar.addSeparator(new Dimension(20,30));		// 두 버튼 사이의 간격 조절
		toolBar.add(button2);
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam19 {

	public static void main(String[] args) {
		Swing19 swing = new Swing19();

	}

}
