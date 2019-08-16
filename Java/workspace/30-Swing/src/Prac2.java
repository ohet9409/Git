import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

class SwingPrac2 extends JFrame implements ActionListener{
	Container container = getContentPane();
	// JToolBar 영역
	JToolBar toolBar = new JToolBar();
	JButton button1 = new JButton("1번");
	JButton button2 = new JButton(new ImageIcon("img/middle.gif"));
	JButton button3 = new JButton("3번");
	JButton button4 = new JButton("4번");
	// JTabbedPane 영역
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);
	JPanel tpJPanel1 = new JPanel();
	JPanel tpJPanel2 = new JPanel();
	JPanel tpJPanel3 = new JPanel();
	JPanel tpJPanel4 = new JPanel();
	public SwingPrac2() {
		// JFrame 설정
		setTitle("SwingPrac2");
		setSize(500, 300);
		setLocation(1300, 300);
		setResizable(false);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",toolBar);
		container.add("Center",tabbedPane);
		// toolBar 구성
		toolBar.add(button1);
		toolBar.addSeparator();		// 간격 두기
		toolBar.add(button2);
		toolBar.addSeparator();
		toolBar.add(button3);
		toolBar.addSeparator();
		toolBar.add(button4);
		// tabbedPane 구성
		tabbedPane.add("1번채널",tpJPanel1);
		tpJPanel1.setBackground(Color.BLACK);
		tabbedPane.add("2번채널",tpJPanel2);
		tpJPanel2.setBackground(Color.RED);
		tabbedPane.add("3번채널",tpJPanel3);
		tpJPanel3.setBackground(Color.GREEN);
		tabbedPane.add("4번채널",tpJPanel4);
		tpJPanel4.setBackground(Color.BLUE);
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		button1.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				tabbedPane.setSelectedIndex(0);		
//				
//			}
//		});
//		button2.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				tabbedPane.setSelectedIndex(1);
//				
//			}
//		});
//		button3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				tabbedPane.setSelectedIndex(2);
//				
//			}
//		});
//		button4.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				tabbedPane.setSelectedIndex(3);
//				
//			}
//		});
		// 버튼 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			tabbedPane.setSelectedIndex(0);
		} else if(e.getSource() == button2) {
			tabbedPane.setSelectedIndex(1);
		} else if(e.getSource() == button3) {
			tabbedPane.setSelectedIndex(2);
		} else if(e.getSource() == button4) {
			tabbedPane.setSelectedIndex(3);
		} 
		
	}

	
}
public class Prac2 {

	public static void main(String[] args) {
		SwingPrac2 swing = new SwingPrac2();

	}

}
