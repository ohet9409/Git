import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;
 
import java.awt.event.WindowListener;

class BaseForm extends Frame implements ActionListener{
	Button button1 = new Button("버튼1");
	Button button2 = new Button("버튼2");
	Button button3 = new Button("버튼3");
	// 컴포넌트 : 화면을 꾸며주는 클래스
	// FlowLayout : 컴포넌트를 왼쪽에서 오른쪽으로 배치 
	FlowLayout flowLayout = new FlowLayout();
	// GridLayout : 컴포넌트를 행열로 배치
	// public GridLayout(int rows,
//    					int cols,
//    					int hgap,
//    					int vgap)
	GridLayout gridLayout = new GridLayout(2,2,5,50);
	// BorderLayout : 컴포넌트를 동서남북으로 배치
	BorderLayout borderLayout = new BorderLayout();
	
	public BaseForm() {
		// frame 설정
		setTitle("Layout Manager");
		setSize(300,200);
		setLocation(1300, 300);		// 모니터 기준 위치
		
		init1();		// 화면 구성
		start();	// 이벤트 구성
		setVisible(true);
	}
	// 화면 구성 : FlowLayout, GridLayout, 
	private void init() {
//		setLayout(flowLayout);
		setLayout(gridLayout);
//		setLayout(borderLayout);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.green);
		button3.setBackground(Color.CYAN);
		add(button1);
		add(button2);
		add(button3);
		
	}
	// 화면 구성 : BorderLayout
	private void init1() {
//		setLayout(flowLayout);
//		setLayout(gridLayout);
		setLayout(borderLayout);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.green);
		button3.setBackground(Color.CYAN);
//		add("North",button1);
		add("West",button1);
		add("Center",button2);
//		add("South",button3);
		add("East", button3);
		
	}
	// 이벤트 구성
	private void start() {
		// 버튼을 눌렀을 때의 처리
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		// 프레임 정의 x버튼의 종료 처리
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);		// 부속 클래스이므로 this(부모클래스)를 써줘야 한다. 
		dialog.setLocation(1400,400);
		if(e.getSource() == button1) {
			dialog.setTitle("버튼1");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("버튼2");
			dialog.setVisible(true);
		} else if(e.getSource() == button3) {
			dialog.setTitle("버튼3");
			dialog.setVisible(true);
		} 
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose(); 		// Dialog 창 닫기
				super.windowClosing(e);
			}
		});
		
	}
	
}
public class Exam5 {

	public static void main(String[] args) {
		BaseForm baseForm = new BaseForm();

	}

}
