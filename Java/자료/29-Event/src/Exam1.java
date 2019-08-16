import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionDefine implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {		
		System.exit(0);
	}	
}
class Event1 extends Frame {
	Button button;
	ActionDefine actionDefine;
	
	public Event1() {
		button = new Button("확인");
		actionDefine = new ActionDefine();
		// Frame 설정
		setTitle("Event 클래스 이용");
		setSize(300, 200);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		// 버튼에 이벤트 등록
		button.addActionListener(actionDefine);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Event1 event1 = new  Event1();
	}
}






