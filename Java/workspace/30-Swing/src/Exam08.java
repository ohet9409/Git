import java.awt.Container;
import java.awt.FlowLayout;

import javax.naming.InitialContext;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;

class Swing08 extends JFrame {
	Container container = getContentPane();
	JButton[] button = new JButton[6];
	Box box1, box2, box3;
	
	public Swing08() {
		// JFrame 설정
		setTitle("Swing08");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		for(int x=0; x<button.length; x++) {
			button[x]=new JButton(String.valueOf(x+1));	//String.valueOf(x+1) --> 문자열로 바꿈 button에는 문자열만 입력 가능
		}
		// 세로축으로 컴포넌트를 추가하는 Box 객체를 생성
		box1 = Box.createVerticalBox();
		box1.add(Box.createVerticalStrut(10));  // 세로로 10픽셀의 사이 간격을 지정
		for(int x=0; x<3; x++) {
			box1.add(button[x]);
			box1.add(Box.createVerticalStrut(10));	// 버튼 사이 간격을 10픽셀 간격으로 조정
		}
		// 가로축으로 컴포넌트를 추가하는 Box 객체를 생성
		box2 =Box.createHorizontalBox();
		box2.add(Box.createVerticalStrut(170));		// 전체적으로 세로 로 내려간다
		
		for(int x=3; x<6; x++) {
			box2.add(button[x]);
			box2.add(Box.createHorizontalStrut(10));
		}
		box3 =Box.createHorizontalBox();
		
		box3.add(box1);
		box3.add(Box.createHorizontalStrut(30));
		box3.add(box2);
		
		container.add(box3);
		
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam08 {

	public static void main(String[] args) {
		Swing08 swing08 = new Swing08();

	}

}
