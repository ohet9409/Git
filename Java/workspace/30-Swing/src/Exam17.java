import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

class Swing17 extends JFrame {
	Container container = getContentPane();
	JLabel jLabel = new JLabel("이것은 탭 팬입니다");
	JButton button1 = new JButton("확인");
	JButton button2 = new JButton("취소");
	JPanel panelButton = new JPanel();
	// 탭
	JPanel panel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM,JTabbedPane.SCROLL_TAB_LAYOUT);
	JButton tbtn1 = new JButton("첫번째 Tab");
	JButton tbtn2 = new JButton("두번째 Tab");
	JButton tbtn3 = new JButton("세번째 Tab");
	JButton tbtn4 = new JButton("네번째 Tab");
	JButton tbtn5 = new JButton("다섯번째 Tab");
	
	JPanel tPanel1 = new JPanel();
	JPanel tPanel2 = new JPanel();
	JPanel tPanel3 = new JPanel();
	JPanel tPanel4 = new JPanel();
	JPanel tPanel5 = new JPanel();
	
	public Swing17() {
		// JFrame 설정
		setTitle("Swing17");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",jLabel);
		container.add("Center",panel);
		container.add("South",panelButton);
		// panelButton 구성
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelButton.add(button1);
		panelButton.add(button2);
		// panel 구성(Tab)
		tabbedPane.add(tbtn1);
		tabbedPane.add(tbtn2);
		tabbedPane.add(tbtn3);
		tabbedPane.add("Title",tbtn4);
		// 이미지와 함께 탭 추가
		tabbedPane.addTab("Title", new ImageIcon("img/middle.gif"),tbtn5,"여긴 아이콘이 있습니다.");
		
		tPanel1.setBackground(Color.YELLOW);
		tPanel2.setBackground(Color.gray);
		tPanel3.setBackground(Color.green);
		tPanel4.setBackground(Color.blue);
		tPanel5.setBackground(Color.red);
		
		tabbedPane.add("Yellow",tPanel1);
		tabbedPane.add("Gray",tPanel2);
		tabbedPane.add("Green",tPanel3);
		tabbedPane.add("Blue",tPanel4);
		tabbedPane.add("Red",tPanel5);
		panel.setLayout(new BorderLayout());
		panel.add("Center",tabbedPane);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam17 {

	public static void main(String[] args) {
		Swing17 swing = new Swing17();

	}

}
