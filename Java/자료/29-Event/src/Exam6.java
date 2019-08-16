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

class PanelForm extends Frame implements ActionListener {
	Button button1 = new Button("버튼1");
	Button button2 = new Button("버튼2");
	BorderLayout borderLayout = new BorderLayout();
	GridLayout gridLayout = new GridLayout(1, 2);	// 1행 2열
	Panel panel = new Panel();
	
	public PanelForm() {
		// Frame 설정
		setTitle("Panel");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	// 화면 구성
	private void init() {
		setLayout(borderLayout);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.GREEN);
		panel.setLayout(gridLayout);
		panel.add(button1);
		panel.add(button2);
		add("South", panel);
	}
	// 이벤트 설정
	private void start() {
		button1.addActionListener(this);
		button2.addActionListener(this);
		// 프레임 x버튼 종료 처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
				super.windowClosing(e);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Dialog dialog = new Dialog(this);
		dialog.setLocation(1400, 400);
		
		if(e.getSource() == button1) {
			dialog.setTitle("버튼1");
			dialog.setVisible(true);
		} else if(e.getSource() == button2) {
			dialog.setTitle("버튼2");
			dialog.setVisible(true);
		}
		
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose();
				super.windowClosing(e);
			}
		});
	}	
}
public class Exam6 {
	public static void main(String[] args) {
		PanelForm panelForm = new PanelForm();
	}
}





