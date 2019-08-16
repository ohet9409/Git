import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Event extends Frame implements ActionListener{
	Button button1 = new Button("test");
	Button button2 = new Button("test1");
	Button button3 = new Button("test2");
	BorderLayout borderLayout = new BorderLayout();	// 프레임 용(동서남북)
	GridLayout gridLayout1 = new GridLayout(1,2);	// 패널용 (1행 2열)
	GridLayout gridLayout2 = new GridLayout(2,1);	// 패널용 (2행 1열)
	Panel panel = new Panel();
	Panel panel2 = new Panel();
//	Panel panel = new Panel(new GridLayout(1,2));	// 1행 2열
//	Panel panel2 = new Panel(new GridLayout(2,1));	// 2행 1열
	
	public Event() {
		// frame 설정
		setTitle("Panel 연습");	// 화면 제목
		setSize(300, 200);		// 화면 크기
		setLocation(1300, 300);	// 화면 위치
		init();					// 화면 구성
		start();				// 이벤트 설정
		setVisible(true);		// 화면 보이기
	} 
	private void init() {
		setLayout(borderLayout);				// Frame에 Layout 설정
		button1.setBackground(Color.YELLOW);	
		button2.setBackground(Color.MAGENTA);
		button3.setBackground(Color.GREEN);
		panel.setLayout(gridLayout1);			// Panel에 Layout 설정
		panel2.setLayout(gridLayout2);			// Pane2에 Layout 설정
		panel.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel.add(panel2);						// Panel에 Panel2 추가(2열에 추가됨)
		add("South",panel);						// 남쪽에 panel을 위치 시킨다.
	}
	private void start() {
		// 버튼의 이벤트 연결
		button1.addActionListener(this);	// this : actionPerformed 함수
		button2.addActionListener(this);
		button3.addActionListener(this);
		// frame 창의 x버튼 종료 처리
		this.addWindowListener(new WindowAdapter() {	// 무명클래스 방법
			@Override
			public void windowClosing(WindowEvent e) {	// 윈도우 창닫기
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {	// 버튼 클릭
		Dialog dialog = new Dialog(this);	// 버튼 클릭시 창 뜨기 /  this : 현재 프레임
		dialog.setLocation(1400, 400);
		if(e.getSource() == button1) {
			dialog.setTitle("Test");
			dialog.setVisible(true);
		}else if(e.getSource() == button2) {
			dialog.setTitle("Test1");
			dialog.setVisible(true);
		}else if(e.getSource() == button3) {
			dialog.setTitle("Test2");
			dialog.setVisible(true);
		} 
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {		// 팝업 창 닫기
				dialog.dispose();			
				super.windowClosing(e);
			}
		});
	}
	
}
public class Prac1 {

	public static void main(String[] args) {
		Event event = new Event();

	}

}
