import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Event2 extends Frame implements ActionListener{
	Button button = new Button("Ȯ��");;
	
	public Event2() {
		// Frame ����
		setTitle("Event Listener ��� �̿�");
		setSize(300, 200);
		
		init();	//ȭ�鱸��
		start();//�̺�Ʈ ����
		
		setVisible(true);
	}
	// ȭ�鱸��
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// �̺�Ʈ ����
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




