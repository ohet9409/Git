import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event2 extends Frame implements ActionListener{
	Button button = new Button("확인");;
	
	public Event2() {
		// Frame 설정
		setTitle("Event Listener 상속 이용");
		setSize(300, 200);
		
		init();	//화면구성
		start();//이벤트 설정
		
		setVisible(true);
	}
	// 화면구성
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		button.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0); 
	}
	
}
public class Exam2 {
	public static void main(String[] args) {
		Event2 event2 = new Event2();
	}
}




