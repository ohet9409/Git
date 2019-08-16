import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

class Form3 extends Frame{
	private Button button;
	
	Form3() {
		button = new Button("확인");
		// Frame 설정
		setTitle("기본화면3");
		setSize(300,200);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(null);	// 화면 분할에 Layout을 사용하지 않겠다고 설정
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// 이벤트 설정
	private void start() {
		
	}
}
public class Exam3 {

	public static void main(String[] args) {
		Form3 form3 = new Form3();
		

	}

}
