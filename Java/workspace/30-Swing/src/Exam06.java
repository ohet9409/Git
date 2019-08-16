import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

class Swing06 extends JFrame implements ActionListener{
	Container container = getContentPane();							// ContentPane에 프레임 만듬
	JRadioButton radioButtonbutton1 = new JRadioButton("여자",true); // true일때 기본 선택되어진다
	JRadioButton radioButtonbutton2 = new JRadioButton("남자");
	JRadioButton radioButtonbutton3 = new JRadioButton("청소년");
	JRadioButton radioButtonbutton4 = new JRadioButton("성인",true);
	ButtonGroup buttonGroup = new ButtonGroup();		// 그룹으로 묶어서 한가지 버튼만 선택가능
	ButtonGroup buttonGroup2 = new ButtonGroup();		// 그룹으로 묶어서 한가지 버튼만 선택가능
	public Swing06() {
		// JFrame 설정
		setTitle("Swing06");
		setSize(200, 100);
		setLocation(1300, 300);
		
		init();			// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		this.setSize(200, 100);
		this.setLayout(new GridLayout(2,2,5,5));	// 2행 2열 5,5 가로세로 크기
		container.add(radioButtonbutton1);			// 화면에 버튼 추가
		container.add(radioButtonbutton2);
		container.add(radioButtonbutton3);
		container.add(radioButtonbutton4);
		
		buttonGroup.add(radioButtonbutton1);		// 버튼 그룹에 버튼 추가
		buttonGroup.add(radioButtonbutton2);
		
		buttonGroup2.add(radioButtonbutton3);
		buttonGroup2.add(radioButtonbutton4);	
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// radioButton 이벤트 설정
		radioButtonbutton1.addActionListener(this);		// 버튼의 액션 추가
		radioButtonbutton2.addActionListener(this);
		radioButtonbutton3.addActionListener(this);
		radioButtonbutton4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioButtonbutton1) {
			System.out.println("radioButtonbutton1 = "+radioButtonbutton1.isSelected());
		} else if(e.getSource() == radioButtonbutton2) {
			System.out.println("radioButtonbutton2 = "+radioButtonbutton2.isSelected());
		} else if(e.getSource() == radioButtonbutton3) {
			System.out.println("radioButtonbutton3 = "+radioButtonbutton3.isSelected());
		} else if(e.getSource() == radioButtonbutton4) {
			System.out.println("radioButtonbutton4 = "+radioButtonbutton4.isSelected());
		} 
		
	}
}
public class Exam06 {

	public static void main(String[] args) {
		Swing06 swing06 = new Swing06();

	}

}
