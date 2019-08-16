import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;

class Swing26 extends JFrame implements ActionListener{
	Container container = getContentPane();
	JButton button = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	public Swing26() {
		// JFrame 설정
		setTitle("Swing");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center",button);
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 버튼 이벤트 설정
		button.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			container.remove(button);	// 없애기
			container.invalidate();     // 무효화
			container.add("Center",button2);	// 추가
			container.validate(); 		// 유효화
			container.repaint();  		// 화면 갱신
		} else if(e.getSource() == button2) {
			container.remove(button2);	// 없애기
			container.invalidate();     // 무효화
			container.add("Center",button);	// 추가
			container.validate(); 		// 유효화
			container.repaint();  		// 화면 갱신
		}
		
	}
}
public class Exam26 {

	public static void main(String[] args) {
		Swing26 swing = new Swing26();

	}

}
