
import java.awt.BorderLayout;
import java.awt.Container;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

class Swing23 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("Test");
	JButton buttonUp = new JButton("위 버튼");
	JButton buttonDown = new JButton("아래 버튼");
	JButton buttonLeft = new JButton("좌측 버튼");
	
	JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,true,buttonUp,buttonDown);
	JSplitPane splitPane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,buttonLeft,splitPane);
	
	
	public Swing23() {
		// JFrame 설정
		setTitle("Swing23");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",splitPane2);
		// 아래의 컴포넌트를 다른 컴포넌트로 변경
		JButton buttonDown1 = new JButton("아래1 버튼");
		splitPane.setBottomComponent(buttonDown1);
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam23 {

	public static void main(String[] args) {
		Swing23 swing = new Swing23();

	}

}
