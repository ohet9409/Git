import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Event4 extends Frame{
	Button button = new Button("확인");
	Event4(){
		setTitle("이용");
		setSize(300, 200);
		init();
		start();
		setVisible(true);
	}
	private void start() {
		ActionListener actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		};
		button.addActionListener(actionListener);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				super.windowClosing(e);
			}
		});
	}
	private void init() {
		setLayout(null);
		button.setBackground(Color.yellow);
		button.setBounds(100, 100, 80, 30);
		add(button);
		
	}
	
}
class Exam4 {

	public static void main(String[] args) {
		Event4 event4 = new Event4();

	}

}
