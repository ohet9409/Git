import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.naming.InitialContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class Swing extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("개인정보");
	JLabel label2 = new JLabel("이름: ",JLabel.RIGHT);
	JLabel label3 = new JLabel("주민번호: ",JLabel.LEFT);
	JLabel label4 = new JLabel("전화번호: ",JLabel.RIGHT);
	JLabel label5 = new JLabel("주소: ",JLabel.RIGHT);
	JLabel label6 = new JLabel("정보검색",JLabel.RIGHT);
	JLabel label7 = new JLabel("검색: ",JLabel.LEFT);
	
	JTextField textField = new JTextField();
	JTextField textField2 = new JTextField();
	JTextField textField3 = new JTextField();
	JTextField textField4 = new JTextField();
	JTextField textField5 = new JTextField();
	JTextField textField6 = new JTextField();
	JTextField textField7 = new JTextField();
	
	JTextArea textArea = new JTextArea();
	
	
	
	JButton button4 = new JButton("검색");
	JButton button = new JButton("<<");
	JButton button2 = new JButton(">>");
	
	JPanel panel = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel panel_1_1 = new JPanel();
	JPanel panel_1_2 = new JPanel();
	JPanel panel_1_3 = new JPanel();
	JPanel panel_1_4 = new JPanel();
	JPanel panel_2 = new JPanel();
	JPanel panel_2_1 = new JPanel();
	JPanel panel_2_2 = new JPanel();
	
	JPanel panel2 = new JPanel();
	JLabel label8 = new JLabel("개인정보화면");
	JButton button3 = new JButton("전체보기");
	JLabel label9 = new JLabel("<--이것을 누르면 전체보기가 됩니다.");
	JTextArea textArea2 = new JTextArea();
	JButton button2_1 =new JButton("등록");
	JButton button2_2 =new JButton("수정");
	JButton button2_3 =new JButton("삭제");
	JButton button2_4 =new JButton("Clear");
	JButton button2_5 =new JButton("저장");
	JButton button2_6 =new JButton("로드");
	JButton button2_7 =new JButton("종료");
	JPanel panel2_1 = new JPanel();
	JPanel panel2_2 = new JPanel();
	public Swing() {
		// JFrame 설정
		setTitle("Swing");
		setSize(800, 500);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",panel);
		
		panel_1_1.setLayout(new GridLayout(4,1));	// 개인정보
		panel_1_1.add(label2);						// 이름
		panel_1_1.add(label3);
		panel_1_1.add(label4);
		panel_1_1.add(label5);
		
		panel_1_3.setLayout(new GridLayout(1,2,5,5));
		panel_1_3.add(textField5);
		panel_1_3.add(textField6);
		
		panel_1_2.setLayout(new GridLayout(4,2));	// 개인정보
		panel_1_2.add(textField);					// 이름
		panel_1_2.add(panel_1_3);					// 주민번호
		panel_1_2.add(textField3);					// 전화번호
		panel_1_2.add(textField4);					// 주소
		
		
		
		
//		panel_1_2.setLayout(new GridLayout());
//		panel_1_1.setLayout(new FlowLayout(10));
//		panel_1_1.add("West",label2);
//		panel_1_1.add(textField);
//		
//		panel_1_2.setLayout(new FlowLayout(10));
//		panel_1_2.add(label3);
//		panel_1_2.add(textField2);
//		panel_1_2.add(textField3);
		
//		panel_1_3.setLayout(new FlowLayout(10));
//		panel_1_3.add("West",label4);
//		panel_1_3.add(textField4);
		
//		panel_1_4.setLayout(new FlowLayout(10));
//		panel_1_4.add(label5);
//		panel_1_4.add(textField5);
		
		panel_1.setLayout(new BorderLayout());
		panel_1.add("West",panel_1_1);
		panel_1.add("Center",panel_1_2);
//		panel_1.add(panel_1_3);
//		panel_1.add(panel_1_4);
		
		panel_2_1.setLayout(new GridLayout(1,4));
		panel_2_1.add(label7);
		panel_2_1.add(textField6);
		panel_2_1.add(textField7);
		panel_2_1.add(button4);
		
		panel_2_2.setLayout(new FlowLayout());
		panel_2_2.add(button);
		panel_2_2.add(button2);
		
			
		panel_2.setLayout(new BorderLayout());
		panel_2.add("North",panel_2_1);
		panel_2.add("Center",textArea);
		panel_2.add("South",panel_2_2);
		
		panel2.setLayout(new BorderLayout());
		panel2.add("North",panel2_1);
		panel2.add("Center",textArea2);
		panel2.add("South",panel2_2);
		
		panel2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_1.add(button3);
		panel2_1.add(label9);
		
		panel2_2.setLayout(new GridLayout(1,7));
		panel2_2.add(button2_1);
		panel2_2.add(button2_2);
		panel2_2.add(button2_3);
		panel2_2.add(button2_4);
		panel2_2.add(button2_5);
		panel2_2.add(button2_6);
		panel2_2.add(button2_7);
		
		container.add(panel2);
//		panel2.add(panel2_1);
//		panel2.add(textArea2);
//		panel2.add(panel2_2);
		panel2.setBorder(new TitledBorder("개인정보화면"));
		panel.setLayout(new GridLayout(2,1));
		panel_1.setBorder(new TitledBorder("개인정보"));
		panel_2.setBorder(new TitledBorder("정보검색"));
		panel.add(panel_1);
		panel.add(panel_2);
		
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Prac1 {

	public static void main(String[] args) {
		Swing swing = new Swing();

	}

}
