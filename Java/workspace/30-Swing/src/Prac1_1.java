import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

class SwingPrac1 extends JFrame {
	Container container = getContentPane();
	// 개인정보 영역
	JLabel labelName = new JLabel("이름: ", JLabel.RIGHT);
	JLabel labelJu = new JLabel("주민번호: ", JLabel.RIGHT);
	JLabel labelTel = new JLabel("전화번호: ", JLabel.RIGHT);
	JLabel labelAddr = new JLabel("주소: ", JLabel.RIGHT);

	JTextField textFieldName = new JTextField(14); // 텍스트 필드 크기 지정
	JTextField textFieldJu1 = new JTextField(7);
	JTextField textFieldJu2 = new JTextField(7);
	JTextField textFieldTel = new JTextField(14);
	JTextField textFieldAddr = new JTextField(14);
	// 수직으로 줄 맞추기
	JPanel panelLU = new JPanel(); // 전체를 묶어주는 패널
	JPanel panelLable = new JPanel(); // 레이블을 묶어주는 패널
	JPanel panelText = new JPanel(); // textField를 묶어주는 패널
	JPanel panelJu = new JPanel();	// 주민번호 textField를 묶어주는 패널
	// ----------------------------------------------------//
	// 정보검색 영역
	JLabel labelS = new JLabel("검색 : ");
	JTextField textFieldS1 = new JTextField(7);
	JTextField textFieldS2 = new JTextField(7);
	JTextArea textAreaS = new JTextArea();
	JScrollPane scrollPaneS = new JScrollPane(textAreaS);
	JButton buttonS = new JButton("검색");
	JButton buttonAL = new JButton("<<");
	JButton buttonAR = new JButton(">>");

	JPanel panelLD = new JPanel(); // 전체를 묶어주는 패널
	JPanel panelS = new JPanel(); // 검색기능을 묶어주는 패널
	JPanel panelBtn = new JPanel(); // 버튼을 묶어주는 패널
	JPanel panelSC = new JPanel(); 	// 검색 textField 묶어주는 패널
	// ----------------------------------------------------//
	// 개인정보확인 영역
	JLabel labelR = new JLabel("<== 이것을 누르면 전체보기가 됩니다.");
	JTextArea textAreaR = new JTextArea();
	JScrollPane jScrollPaneR = new JScrollPane(textAreaR);
	JButton buttonR = new JButton("전체보기");
	JButton button1 = new JButton("등록");
	JButton button2 = new JButton("수정");
	JButton button3 = new JButton("삭제");
	JButton button4 = new JButton("Clear");
	JButton button5 = new JButton("저장");
	JButton button6 = new JButton("로드");
	JButton button7 = new JButton("종료");
	
	JPanel panelR = new JPanel(); 		// 전체를 묶어주는 패널
	JPanel panelRT = new JPanel();  	// 전체보기를 묶어주는 패널
	JPanel panelRB = new JPanel();		// 버튼을 묶어주는 패널
	//-------------------------------------------------------//
	JPanel panelL = new JPanel();	// 개인정보영역 + 정보검색영역을 묶어주는 panel

	public SwingPrac1() {
		// JFrame 설정
		setTitle("SwingPrac1");
		setSize(720, 400);
		setLocation(1100, 300);
		setResizable(false); // 창 크기변환 금지

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",panelL);
		container.add("Center",panelR);
		/** panelL 구성 */
		panelL.setLayout(new GridLayout(2,1,3,3));
		panelL.add(panelLU);
		panelL.add(panelLD);
		/* 왼쪽 상단부*/
		panelLU.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"개인정보"));	// 양각효과와 타이틀 효과 주기
		panelLU.setLayout(new BorderLayout());
		panelLU.add("West",panelLable);
		panelLU.add("Center",panelText);
		// panelLable 구성
		panelLable.setLayout(new GridLayout(4,1));
		panelLable.add(labelName);
		panelLable.add(labelJu);
		panelLable.add(labelTel);
		panelLable.add(labelAddr);
		// panelText 구성
		panelText.setLayout(new GridLayout(4,1));
		panelText.add(textFieldName);
		panelText.add(panelJu);
		
		panelText.add(textFieldTel);
		panelText.add(textFieldAddr);
		// panelJu 구성
		panelJu.setLayout(new GridLayout(1,2,3,3));
		panelJu.add(textFieldJu1);
		panelJu.add(textFieldJu2);
		/* 왼쪽 하단부*/
		panelLD.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"정보검색"));
		panelLD.setLayout(new BorderLayout());
		panelLD.add("North",panelS);
		panelLD.add("Center",scrollPaneS);
		panelLD.add("South",panelBtn);
		// panelS 구성
		panelS.setLayout(new BorderLayout());
		panelS.add("West",labelS);
		panelS.add("Center",panelSC);
		panelS.add("East",buttonS);
		// panelSC 구성
		panelSC.setLayout(new GridLayout(1,2,3,3));
		panelSC.add(textFieldS1);
		panelSC.add(textFieldS2);
		// panelBtn 구성
		panelBtn.setLayout(new FlowLayout());
		panelBtn.add(buttonAL);
		panelBtn.add(buttonAR);
		/** panelR 구성 */
		panelR.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"개인정보확인"));
		panelR.setLayout(new BorderLayout());
		panelR.add("North",panelRT);
		panelR.add("Center",jScrollPaneR);
		panelR.add("South",panelRB);
		// panelRT 구성
		panelRT.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelRT.add(buttonR);
		panelRT.add(labelR);
		// panelRB 구성
		panelRB.setLayout(new GridLayout(1,7));
		panelRB.add(button1);
		panelRB.add(button2);
		panelRB.add(button3);
		panelRB.add(button4);
		panelRB.add(button5);
		panelRB.add(button6);
		panelRB.add(button7);
		
		// 버튼 사용 금지 설정
		buttonS.setEnabled(false);
		buttonAL.setEnabled(false);
		buttonAR.setEnabled(false);
		buttonR.setEnabled(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

public class Prac1_1 {

	public static void main(String[] args) {
		SwingPrac1 swing = new SwingPrac1();

	}

}
